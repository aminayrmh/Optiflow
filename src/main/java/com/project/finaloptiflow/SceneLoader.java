package com.project.finaloptiflow;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ActionEvent actionEvent;

    public void setActionEvent(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
    }

    void sceneLoad(String viewName){
        try {
            root = FXMLLoader.load(getClass().getResource("/com/project/finaloptiflow/" + viewName + ".fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com/project/css/stylesheets.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
