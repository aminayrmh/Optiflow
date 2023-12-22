package com.project.finaloptiflow;


import com.project.finaloptiflow.database.DataBaseConnection;
import com.project.finaloptiflow.database.Database;
import javafx.fxml.FXML;

import javafx.scene.control.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResetPasswordController {
    @FXML
    private TextField usernameResetField;

    @FXML
    private PasswordField newPassResetField;

    @FXML
    private PasswordField confirmNewPassResetField;

    @FXML
    private Hyperlink goBackButton;

    @FXML
    private Button resetButton;

    @FXML
    private Label dataIsNotCorrect;

    @FXML
    void initialize() {

        goBackButton.setOnAction(actionEvent -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(actionEvent);
            sceneLoader.sceneLoad("login-view");
        });

        resetButton.setOnAction(actionEvent -> {
            Database db = new Database();
            ResultSet resultSet = null;
            if (usernameResetField.getText().isEmpty() || newPassResetField.getText().isEmpty() ||
                    confirmNewPassResetField.getText().isEmpty()){
                dataIsNotCorrect.setText("Please, enter username and new password.");

            } else {
                if (newPassResetField.getText().equals(confirmNewPassResetField.getText())) {
                    resultSet = db.check(usernameResetField.getText().trim());

                    try {
                        if (resultSet.next()){
                            db.update(usernameResetField.getText().trim(), newPassResetField.getText().trim());
                            SceneLoader sceneLoader = new SceneLoader();
                            sceneLoader.setActionEvent(actionEvent);
                            sceneLoader.sceneLoad("login-view");
                        }else {
                            dataIsNotCorrect.setText("There is no user with such username.");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    dataIsNotCorrect.setText("New password does not match!");
                }
            }
        });
    }
}
