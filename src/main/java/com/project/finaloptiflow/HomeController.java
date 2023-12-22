package com.project.finaloptiflow;

import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Button addResume;

    @FXML
    private Button forCompanyButton;

    @FXML
    private Button logOut;

    @FXML
    private Button show1;

    @FXML
    private Button show2;

    @FXML
    private Button show3;

    @FXML
    private Button show4;

    @FXML
    private Label showUsername;

    @FXML
    void initialize(){
        Database db = new Database();
        showUsername.setText(db.getFirstName());
        logOut.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("login-view");
        });

        addResume.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("add-resume-view");
        });

        forCompanyButton.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("company-registration-view");
        });

        show1.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("vacancy-1-view");
        });

        show2.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("vacancy-2-view");
        });

        show3.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("vacancy-3-view");
        });

        show4.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("vacancy-4-view");
        });
    }


}
