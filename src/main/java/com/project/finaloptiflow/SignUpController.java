package com.project.finaloptiflow;

import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpController {

    @FXML
    private PasswordField confirmPasswordSignUp;

    @FXML
    private Button createAccountButton;

    @FXML
    private TextField emailSignUp;

    @FXML
    private TextField firstNameSignUp;

    @FXML
    private Hyperlink goBackButton;

    @FXML
    private TextField lastNameSignUp;

    @FXML
    private PasswordField passwordSignUp;

    @FXML
    private Label signUpMessageField;

    @FXML
    private TextField usernameSignUp;


    @FXML
    void initialize() {

        goBackButton.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("login-view");
        });

        createAccountButton.setOnAction(actionEvent -> {
            Database db = new Database();
            ResultSet resultSet = db.check(usernameSignUp.getText().trim());
            if (firstNameSignUp.getText().isEmpty() || lastNameSignUp.getText().isEmpty() ||usernameSignUp.getText().isEmpty() || emailSignUp.getText().isEmpty() ||
                    passwordSignUp.getText().isEmpty() || confirmPasswordSignUp.getText().isEmpty()){
                signUpMessageField.setText("Please, fill in all the fields!");
            } else{
                try {
                    if (passwordSignUp.getText().equals(confirmPasswordSignUp.getText())) {
                        if(!resultSet.next()) {
                            db.signUpUser(usernameSignUp.getText().trim(), firstNameSignUp.getText().trim(), lastNameSignUp.getText().trim(), emailSignUp.getText().trim(), passwordSignUp.getText().trim());
                            try {
                                SceneLoader sceneLoader = new SceneLoader();
                                sceneLoader.setActionEvent(actionEvent);
                                sceneLoader.sceneLoad("home-view");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            signUpMessageField.setText("Username or email address is already being used by another user.");
                        }
                        } else {
                        signUpMessageField.setText("Password does not match!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
