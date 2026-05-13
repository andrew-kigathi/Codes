import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;

public class Rentals extends Application {

    ComboBox<String> customerBox;
    ComboBox<String> genreBox;
    ComboBox<String> movieBox;

    ComboBox<String> borrowedBox;
    ComboBox<String> returnedBox;

    ObservableList<String> borrowed = FXCollections.observableArrayList();
    ObservableList<String> returned = FXCollections.observableArrayList();

    // store movies by genre
    HashMap<String, ObservableList<String>> movieMap = new HashMap<>();

    @Override
    public void start(Stage stage) {

        customerBox = new ComboBox<>();
        customerBox.getItems().addAll("John", "Mary");

        genreBox = new ComboBox<>();
        genreBox.getItems().addAll("Action", "Comedy");

        movieBox = new ComboBox<>();

        borrowedBox = new ComboBox<>();

        returnedBox = new ComboBox<>();

        // movie data by genre
        movieMap.put("Action", FXCollections.observableArrayList("Fast & Furious", "John Wick"));
        movieMap.put("Comedy", FXCollections.observableArrayList("Superbad", "The Hangover"));

        // change movies based on genre selection
        genreBox.setOnAction(e -> {
            String genre = genreBox.getValue();

            if (genre != null) {
                movieBox.setItems(movieMap.get(genre));
                movieBox.setValue(null);
            }
        });

        Button saveBtn = new Button("Save Rental");

        Button returnBtn = new Button("Return Movie");

        saveBtn.setOnAction(e -> {

            if (movieBox.getValue() != null) {

                borrowed.add(movieBox.getValue());

                borrowedBox.setItems(borrowed);
            }
        });

        returnBtn.setOnAction(e -> {

            String movie = borrowedBox.getValue();

            if (movie != null) {

                borrowed.remove(movie);

                returned.add(movie);

                borrowedBox.setItems(borrowed);

                returnedBox.setItems(returned);
            }
        });

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(12);

        root.setStyle(
                "-fx-padding: 20;" +
                        "-fx-background-color: #f4f4f4;" +
                        "-fx-font-family: Arial;");

        root.add(new Label("Customer"), 0, 0);
        root.add(customerBox, 1, 0);

        root.add(new Label("Genre"), 0, 1);
        root.add(genreBox, 1, 1);

        root.add(new Label("Movie"), 0, 2);
        root.add(movieBox, 1, 2);

        saveBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        root.add(saveBtn, 1, 3);

        root.add(new Label("Borrowed Movies"), 0, 4);
        root.add(borrowedBox, 1, 4);

        returnBtn.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        root.add(returnBtn, 1, 5);

        root.add(new Label("Returned Movies"), 0, 6);
        root.add(returnedBox, 1, 6);

        Scene scene = new Scene(root, 350, 450);

        stage.setTitle("Rental System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}