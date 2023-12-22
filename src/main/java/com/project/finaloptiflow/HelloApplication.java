package com.project.finaloptiflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static final String title = "Optiflow";
    static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/project/finaloptiflow/login-view.fxml"));
        Font.loadFont(getClass().getResourceAsStream("/com/project/css/fonts/Montserrat-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/com/project/css/fonts/Montserrat-Regular.ttf"), 14);

        scene = new Scene(fxmlLoader.load(), 1100, 700);
        scene.getStylesheets().add(getClass().getResource("/com/project/css/stylesheets.css").toExternalForm());
        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("/com/project/img/logo.png"))));
        stage.setTitle("Optiflow");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}