package com.project.finaloptiflow.FactoryMethod;

import java.util.List;

public class UserSkills implements Person{
    String email;
    String position;
    String work_period;
    List<String> skills;

    public UserSkills() {
    }

    public UserSkills(List<String> skills) {
        this.skills = skills;
    }

    public UserSkills(String email, String position, String work_period, List<String> skills) {
        this.email = email;
        this.position = position;
        this.work_period = work_period;
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
}
