package com.project.finaloptiflow;

import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddResumeController {

    @FXML
    private Button addButton;

    @FXML
    private Button addResume;

    @FXML
    private TextField email;

    @FXML
    private Button forCompanyButton;

    @FXML
    private Button home;

    @FXML
    private Button logOut;

    @FXML
    private TextField position;

    @FXML
    private Label signUpMessageField;

    @FXML
    private TextField skills;

    @FXML
    private TextField workPeriod;
    @FXML
    void initialize(){
        addButton.setOnAction(event -> {
            if (position.getText().isEmpty() || skills.getText().isEmpty() ||
                    workPeriod.getText().isEmpty() || email.getText().isEmpty()) {
                // dataIsNotCorrect.setText("Please, enter username and password.");
            }else {
                Database db = new Database();
                db.workExperience(position.getText().trim(), skills.getText().trim(), workPeriod.getText().trim(), email.getText().trim());
                SceneLoader sceneLoader = new SceneLoader();
                sceneLoader.setActionEvent(event);
                sceneLoader.sceneLoad("home-view");
            }
        });

        home.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("home-view");
        });

        logOut.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("login-view");
        });

        forCompanyButton.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("company-registration-view");
        });
     }

}
