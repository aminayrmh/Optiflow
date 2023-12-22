package com.project.finaloptiflow.Strategy;

import com.project.finaloptiflow.FactoryMethod.UserSkills;
import com.project.finaloptiflow.database.Database;

import java.sql.SQLException;

class SalaryCompatibilityStrategy implements SalaryStrategy{
    Database db = new Database();

    @Override
    public double calculateSalaryCompatibility(UserSkills userSkills) throws SQLException, ClassNotFoundException {
        return 0;
    }
}
