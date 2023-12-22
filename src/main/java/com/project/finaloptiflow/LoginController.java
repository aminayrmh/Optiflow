package com.project.finaloptiflow;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signUpPageButtonClick;

    @FXML
    private Hyperlink resetPassPageButtonClick;

    @FXML
    private Label dataIsNotCorrect;

    @FXML
    void initialize() {

        loginButton.setOnAction(actionEvent -> {
                    if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
                        dataIsNotCorrect.setText("Please, enter username and password.");
                    } else {
                        Database db = new Database();
                        ResultSet resultSet = db.checkUser(usernameTextField.getText().trim(), passwordTextField.getText().trim());
                        try {
                            if (resultSet.next()) {
                                SceneLoader sceneLoader = new SceneLoader();
                                sceneLoader.setActionEvent(actionEvent);
                                sceneLoader.sceneLoad("home-view");
                            } else {
                                dataIsNotCorrect.setText("The account was not found or incorrect password. Please, try again or sign up.");
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                });

        signUpPageButtonClick.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("pre-registration-view");
        });

        resetPassPageButtonClick.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("reset-password-view");
        });
    }
}
