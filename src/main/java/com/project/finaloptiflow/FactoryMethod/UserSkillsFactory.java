package com.project.finaloptiflow.FactoryMethod;

import java.util.List;

public class UserSkillsFactory implements Factory{

    @Override
    public Person create(List<String> list) {
        return new UserSkills(list);
    }
}
