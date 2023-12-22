package com.project.finaloptiflow.Strategy;


import com.project.finaloptiflow.FactoryMethod.UserSkills;
import com.project.finaloptiflow.FactoryMethod.Vacancy;

import java.sql.SQLException;

public interface ExperienceStrategy {
    double calculateExperienceCompatibility(UserSkills user, Vacancy vacancy) throws SQLException, ClassNotFoundException;
}
