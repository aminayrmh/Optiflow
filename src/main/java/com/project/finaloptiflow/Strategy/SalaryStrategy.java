package com.project.finaloptiflow.Strategy;

import com.project.finaloptiflow.FactoryMethod.UserSkills;

import java.sql.SQLException;

public interface SalaryStrategy {
    double calculateSalaryCompatibility(UserSkills userSkills) throws SQLException, ClassNotFoundException;
}
