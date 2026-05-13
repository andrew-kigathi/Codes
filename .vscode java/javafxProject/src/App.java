import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX 26 works");
        Scene scene = new Scene(label, 400, 200);

        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
