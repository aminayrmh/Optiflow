package com.project.finaloptiflow.FactoryMethod;
import java.util.List;

public class Vacancy implements Person{
    String vacancy_name;
    String work_period;
    String description;
    List<String> skills;
    String salary;

    public Vacancy() {
    }

    public Vacancy(List<String> skills) {
        this.skills = skills;
    }

    public Vacancy(String vacancy_name,String description, String work_period, List<String> skills, String salary) {
        this.vacancy_name = vacancy_name;
        this.description = description;
        this.work_period = work_period;
        this.skills = skills;
        this.salary = salary;
    }

    public String getVacancy_name() {
        return vacancy_name;
    }

    public void setVacancy_name(String vacancy_name) {
        this.vacancy_name = vacancy_name;
    }

    public String getWork_period() {
        return work_period;
    }

    public void setWork_period(String work_period) {
        this.work_period = work_period;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
