package com.project.finaloptiflow;

import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ForCompanyController {

    @FXML
    private TextField companyDescription;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private TextField contactNameTextField;

    @FXML
    private Label dataIsNotCorrect;

    @FXML
    private TextField emailTextField;

    @FXML
    private Hyperlink homeButton;

    @FXML
    private TextField phone;

    @FXML
    private Button sendRequest;

    @FXML
    void initialize(){
        homeButton.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("home-view");
        });

        sendRequest.setOnAction(event -> {
            if (companyNameTextField.getText().isEmpty() || contactNameTextField.getText().isEmpty() ||
             emailTextField.getText().isEmpty() || phone.getText().isEmpty() || companyDescription.getText().isEmpty()) {
                dataIsNotCorrect.setText("Please, enter username and password.");
            }else {
                Database db = new Database();
                db.request(companyNameTextField.getText().trim(), contactNameTextField.getText().trim(), emailTextField.getText().trim(), phone.getText().trim(), companyDescription.getText().trim());
                SceneLoader sceneLoader = new SceneLoader();
                sceneLoader.setActionEvent(event);
                sceneLoader.sceneLoad("home-view");
            }
        });
    }

}
