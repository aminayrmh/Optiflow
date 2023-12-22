package com.project.finaloptiflow;

import com.project.finaloptiflow.Strategy.Checker;
import com.project.finaloptiflow.Strategy.SkillsCompatibilityStrategy;
import com.project.finaloptiflow.Strategy.SkillsStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class Vacancy1 {

    @FXML
    private Button Compare;

    @FXML
    private Label getPercentLabel;

    @FXML
    private Label vacancy_name;

    @FXML
    private Hyperlink goBackButton;


    @FXML
    void initialize(){
        Compare.setOnAction(event -> {
                SkillsStrategy skillsStrategy = new SkillsCompatibilityStrategy();
        Checker compatibilityChecker = new Checker(skillsStrategy,null,null);
        double compatibility = 0;
        try {
            compatibility = compatibilityChecker.calculateCompatibility(vacancy_name.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String result = Double.toString(compatibility);
        getPercentLabel.setText(result + "%");
        if (compatibility <= 20) {
            getPercentLabel.setStyle("-fx-text-fill: red");
        } else if (compatibility > 20 && compatibility < 50) {
            getPercentLabel.setStyle("-fx-text-fill: orange");
        } else {
            getPercentLabel.setStyle("-fx-text-fill: green");
        }
        });

        goBackButton.setOnAction(event -> {
            SceneLoader sceneLoader = new SceneLoader();
            sceneLoader.setActionEvent(event);
            sceneLoader.sceneLoad("home-view");

        });
    }

}
