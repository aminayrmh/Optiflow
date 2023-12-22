package com.project.finaloptiflow.Composite;

public class JobLeaf implements JobComponent {
    private String jobDetails;

    public JobLeaf(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    
    @Override
    public void displayJobDetails() {
        System.out.println(jobDetails);
    }
}
