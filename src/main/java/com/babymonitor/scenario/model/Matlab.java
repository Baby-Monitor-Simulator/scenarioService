package com.babymonitor.scenario.model;

import org.bson.Document;

public class Matlab {
    private int oxygenSaturation;
    private int bloodPresure;
    private int hartRate;

    public Matlab() {
    }

    public Matlab(int oxygenSaturation, int bloodPresure, int hartRate) {
        this.oxygenSaturation = oxygenSaturation;
        this.bloodPresure = bloodPresure;
        this.hartRate = hartRate;
    }

    public int getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(int oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public int getBloodPresure() {
        return bloodPresure;
    }

    public void setBloodPresure(int bloodPresure) {
        this.bloodPresure = bloodPresure;
    }

    public int getHartRate() {
        return hartRate;
    }

    public void setHartRate(int hartRate) {
        this.hartRate = hartRate;
    }

    public Document toDocument() {
        return new Document()
                .append("oxygenSaturation", oxygenSaturation)
                .append("bloodPresure", bloodPresure)
                .append("hartRate", hartRate);
    }

    public static Matlab fromDocument(Document doc) {
        return new Matlab(
                doc.getInteger("oxygenSaturation"),
                doc.getInteger("bloodPresure"),
                doc.getInteger("hartRate")
        );
    }
}