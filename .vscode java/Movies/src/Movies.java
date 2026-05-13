import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Movies extends Application {

    ComboBox<String> genreBox;
    TextField nameField;
    ComboBox<String> registeredBox;

    ObservableList<String> movies = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        genreBox = new ComboBox<>();
        genreBox.getItems().addAll(
                "Action",
                "Comedy",
                "Horror",
                "Romance");

        nameField = new TextField();

        registeredBox = new ComboBox<>();

        Button saveBtn = new Button("Save Movie");
        Button removeBtn = new Button("Remove Movie");

        saveBtn.setOnAction(e -> {

            String movie = nameField.getText();

            if (!movie.isEmpty()) {

                movies.add(movie);

                registeredBox.setItems(movies);

                nameField.clear();
            }
        });

        removeBtn.setOnAction(e -> {

            String selectedMovie = registeredBox.getValue();

            movies.remove(selectedMovie);
        });

        GridPane root = new GridPane();

        root.setPadding(new Insets(20));
        root.setVgap(15);
        root.setHgap(10);

        root.add(new Label("Genres:"), 0, 0);
        root.add(genreBox, 1, 0);

        root.add(new Label("Name:"), 0, 1);
        root.add(nameField, 1, 1);

        root.add(saveBtn, 1, 2);

        root.add(new Label("Registered:"), 0, 3);
        root.add(registeredBox, 1, 3);

        root.add(removeBtn, 1, 4);

        saveBtn.setPrefWidth(200);
        removeBtn.setPrefWidth(200);

        genreBox.setPrefWidth(200);
        nameField.setPrefWidth(200);
        registeredBox.setPrefWidth(200);

        Scene scene = new Scene(root, 380, 320);

        stage.setTitle("Movies System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}