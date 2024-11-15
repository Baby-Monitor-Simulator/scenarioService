package com.babymonitor.scenario.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;
import org.springframework.data.annotation.Id;

public class Scenario {
    @Id
    @JsonProperty("_id")
    private String _id;
    private String name;
    private String description;
    private Matlab matlab;

    public Scenario() {
    }
    public Scenario(String name, String description, Matlab matlab) {
        this.name = name;
        this.description = description;
        this.matlab = matlab;
    }
    public Scenario(String _id, String name, String description, Matlab matlab) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.matlab = matlab;
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