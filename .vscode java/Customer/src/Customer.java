import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Customer extends Application {

    TextField nameField;
    TextField phoneField;
    TextField emailField;

    ComboBox<String> registeredBox;

    ObservableList<String> customers = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        nameField = new TextField();

        phoneField = new TextField();

        emailField = new TextField();

        registeredBox = new ComboBox<>();

        Button saveBtn = new Button("Save Customer");

        Button removeBtn = new Button("Remove Customer");

        saveBtn.setOnAction(e -> {

            String customer = nameField.getText() + " - " +
                    phoneField.getText() + " - " +
                    emailField.getText();

            if (!nameField.getText().isEmpty()) {

                customers.add(customer);

                registeredBox.setItems(customers);

                nameField.clear();
                phoneField.clear();
                emailField.clear();
            }
        });

        removeBtn.setOnAction(e -> {

            String selectedCustomer = registeredBox.getValue();

            customers.remove(selectedCustomer);
        });

        GridPane root = new GridPane();

        root.setPadding(new Insets(20));

        root.setHgap(10);

        root.setVgap(15);

        root.setAlignment(Pos.CENTER);

        root.add(new Label("Name:"), 0, 0);
        root.add(nameField, 1, 0);

        root.add(new Label("Phone:"), 0, 1);
        root.add(phoneField, 1, 1);

        root.add(new Label("Email:"), 0, 2);
        root.add(emailField, 1, 2);

        root.add(saveBtn, 1, 3);

        root.add(new Label("Registered:"), 0, 4);
        root.add(registeredBox, 1, 4);

        root.add(removeBtn, 1, 5);

        nameField.setPrefWidth(200);

        phoneField.setPrefWidth(200);

        emailField.setPrefWidth(200);

        registeredBox.setPrefWidth(200);

        saveBtn.setPrefWidth(200);

        removeBtn.setPrefWidth(200);

        Scene scene = new Scene(root, 380, 360);

        stage.setTitle("Customer System");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}