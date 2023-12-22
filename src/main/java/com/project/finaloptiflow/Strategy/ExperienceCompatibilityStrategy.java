package com.project.finaloptiflow.Strategy;

import com.project.finaloptiflow.FactoryMethod.UserSkills;
import com.project.finaloptiflow.FactoryMethod.Vacancy;
import com.project.finaloptiflow.database.Database;

import java.sql.SQLException;

class ExperienceCompatibilityStrategy implements ExperienceStrategy{
    @Override
    public double calculateExperienceCompatibility(UserSkills user, Vacancy vacancy) throws SQLException, ClassNotFoundException {
        return 0;
    }

    Database db = new Database();
}
