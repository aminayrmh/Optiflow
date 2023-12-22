package com.project.finaloptiflow.Composite;

import java.util.ArrayList;
import java.util.List;

public class JobComposite implements JobComponent{
    private List<JobComponent> components = new ArrayList<>();

    public void addComponent(JobComponent component) {
        components.add(component);
    }

    @Override
    public void displayJobDetails() {
        for (JobComponent component : components) {
            component.displayJobDetails();
        }
    }

}
