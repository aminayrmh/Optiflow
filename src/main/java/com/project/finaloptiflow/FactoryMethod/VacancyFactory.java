package com.project.finaloptiflow.FactoryMethod;

import java.util.List;

public class VacancyFactory implements Factory{
    @Override
    public Person create(List<String> list) {
        return new Vacancy(list);
    }
}
