package com.project.finaloptiflow.Strategy;

import java.sql.SQLException;

public interface SkillsStrategy {
    double calculateSkillsCompatibility(String vacancy_name) throws SQLException, ClassNotFoundException;
}
