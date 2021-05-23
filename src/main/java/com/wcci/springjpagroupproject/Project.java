package com.wcci.springjpagroupproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String projectName;

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    protected Project() {
    }

    public Project(Long id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }
}

