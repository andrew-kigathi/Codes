import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            StudentService service = (StudentService) registry.lookup("StudentService");

            List<Student> students = service.getAllStudents();
            for (Student s : students) {
                listView.getItems().add(s.toString());
            }

        } catch (Exception e) {
            listView.getItems().add("Error: " + e.getMessage());
            e.printStackTrace();
        }

        BorderPane root = new BorderPane();
        root.setCenter(listView);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Records");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}