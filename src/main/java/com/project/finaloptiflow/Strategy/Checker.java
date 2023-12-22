package com.project.finaloptiflow.Strategy;

import java.sql.SQLException;

public class Checker {
    private SkillsStrategy skillsStrategy;
    private SalaryStrategy salaryStrategy;
    private ExperienceStrategy experienceStrategy;

    public Checker(SkillsStrategy skillsStrategy, SalaryStrategy salaryStrategy, ExperienceStrategy experienceStrategy) {
        this.skillsStrategy = skillsStrategy;
        this.salaryStrategy = salaryStrategy;
        this.experienceStrategy = experienceStrategy;

    }

    public double calculateCompatibility(String vacancy_name) throws SQLException, ClassNotFoundException {

        double compatibility = skillsStrategy.calculateSkillsCompatibility(vacancy_name);
        return compatibility;
    }
}

