package com.project.finaloptiflow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PreRegistrationController {

    @FXML
    private Button findEmployeeButton;

    @FXML
    private Button findJobButton;

    @FXML
    void initialize() {
        findEmployeeButton.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("registration-view");
        });

        findJobButton.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("registration-view");
        });
    }
}