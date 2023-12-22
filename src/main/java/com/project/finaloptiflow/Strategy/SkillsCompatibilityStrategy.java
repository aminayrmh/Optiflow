package com.project.finaloptiflow.Strategy;

import com.project.finaloptiflow.FactoryMethod.UserSkills;
import com.project.finaloptiflow.FactoryMethod.Vacancy;
import com.project.finaloptiflow.database.Database;

import java.sql.SQLException;
import java.util.List;

public class SkillsCompatibilityStrategy implements SkillsStrategy {
    Database db = new Database();

    @Override
    public double calculateSkillsCompatibility(String vacancy_name) throws SQLException, ClassNotFoundException {
        UserSkills userSkills = (UserSkills) db.getSkills();
        Vacancy vacancy = db.getVacancy(vacancy_name);
        List<String> workerSkills = userSkills.getSkills();
        List<String> requiredSkills = vacancy.getSkills();

        double matchingSkills = workerSkills.stream().filter(requiredSkills::contains).count();
        double totalRequiredSkills = requiredSkills.size();

        double result = Math.round(matchingSkills / totalRequiredSkills * 100);
        return result;
    }
}
