package com.babymonitor.scenario.model;


import org.bson.Document;

public class Scenario {
    private String name;
    private String description;
    private Matlab matlab;

    public Scenario() {
    }
    public Scenario(String name, String description, Matlab matlab) {

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

    public Document toDocument() {
        return new Document()
                .append("name", name)
                .append("description", description)
                .append("matlab", matlab != null ? matlab.toDocument() : null);
    }

    public static Scenario fromDocument(Document doc) {
        return new Scenario(
                doc.getString("name"),
                doc.getString("description"),
                doc.get("matlab") != null ? Matlab.fromDocument(doc.get("matlab", Document.class)) : null
        );
    }
}