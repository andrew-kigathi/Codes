// Name: Andrew Kigathi
// Student ID: 220277
// Date: 22/05/2026

import java.rmi.Naming;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class client extends Application {
    private miniproj remoteObject;
    private TableView<Student> studentTable;
    private Label statusLabel;
    private Button refreshButton;

    @Override
    public void start(Stage stage) {
        studentTable = createStudentTable();
        studentTable.setPlaceholder(new Label("No students loaded"));

        statusLabel = new Label("Connecting...");

        refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> loadStudents());
        refreshButton.setDisable(true);

        HBox topBar = new HBox(12, new Label("Student Details"), refreshButton);
        topBar.setPadding(new Insets(0, 0, 10, 0));

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(topBar);
        root.setCenter(studentTable);
        root.setBottom(statusLabel);

        stage.setTitle("JavaFX RMI Student Client");
        stage.setScene(new Scene(root, 640, 360));
        stage.show();

        connectToServer();
    }

    private void connectToServer() {
        Thread worker = new Thread(() -> {
            try {
                remoteObject = (miniproj) Naming.lookup("rmi://localhost/HelloService");
                Platform.runLater(() -> {
                    refreshButton.setDisable(false);
                    statusLabel.setText("Connected to server.");
                    loadStudents();
                });
            } catch (Exception e) {
                Platform.runLater(() -> statusLabel.setText("Could not connect to server: " + e.getMessage()));
            }
        });
        worker.setDaemon(true);
        worker.start();
    }

    private void loadStudents() {
        refreshButton.setDisable(true);
        statusLabel.setText("Loading students...");

        Thread worker = new Thread(() -> {
            try {
                List<Student> students = remoteObject.getStudents();
                Platform.runLater(() -> {
                    studentTable.setItems(FXCollections.observableArrayList(students));
                    statusLabel.setText("Loaded " + students.size() + " students.");
                });
            } catch (Exception e) {
                Platform.runLater(() -> statusLabel.setText("Failed to load students: " + e.getMessage()));
            } finally {
                Platform.runLater(() -> refreshButton.setDisable(false));
            }
        });
        worker.setDaemon(true);
        worker.start();
    }

    private TableView<Student> createStudentTable() {
        TableView<Student> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        TableColumn<Student, Integer> idColumn = createColumn("ID", "id", 70);
        idColumn.setCellFactory(column -> alignedCell(Pos.CENTER));

        TableColumn<Student, String> nameColumn = createColumn("NAME", "name", 150);
        TableColumn<Student, String> courseColumn = createColumn("COURSE", "course", 110);
        courseColumn.setCellFactory(column -> alignedCell(Pos.CENTER));

        TableColumn<Student, Integer> scoreColumn = createColumn("SCORE", "score", 90);
        scoreColumn.setCellFactory(column -> alignedCell(Pos.CENTER));

        TableColumn<Student, String> emailColumn = createColumn("EMAIL", "email", 220);

        ObservableList<TableColumn<Student, ?>> columns = table.getColumns();
        columns.add(idColumn);
        columns.add(nameColumn);
        columns.add(courseColumn);
        columns.add(scoreColumn);
        columns.add(emailColumn);

        return table;
    }

    private <T> TableColumn<Student, T> createColumn(String title, String property, double width) {
        TableColumn<Student, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(width);
        column.setSortable(false);
        return column;
    }

    private <T> TableCell<Student, T> alignedCell(Pos alignment) {
        TableCell<Student, T> cell = new TableCell<>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.toString());
            }
        };
        cell.setAlignment(alignment);
        return cell;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
