package com.babymonitor.scenario.model;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private Long id;
    private String name;
    private String description;
    private Matlab matlab;

    public Scenario() {
    }
    public Scenario(Long id, String name, String description, Matlab matlab) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Matlab getMatlab() {
        return matlab;
    }

    public void setMatlab(Matlab matlab) {
        this.matlab = matlab;
    }
}