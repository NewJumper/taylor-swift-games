package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenu extends Application {
    public static Stage window;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        stage.setTitle("TS Games");
        stage.getIcons().add(new Image("gui/textures/icon.png"));
        stage.setOnCloseRequest(event -> {
            event.consume();
            try {
                QuitMenu.display();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        showMenu();
        stage.show();
    }

    public static void showMenu() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenu.class.getResource("main.fxml")));
        window.setScene(new Scene(root, 512, 512));
    }

    public void play() throws IOException {
        PlayMenu.playMenu();
    }

    public void scores() {
        System.out.println("scores");
    }

    public void settings() {
        System.out.println("settings");
    }

    public void quit() {
        window.close();
    }
}
