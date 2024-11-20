package com.babymonitor.scenario.model;

import org.bson.Document;

public class Matlab {
    private int oxygenSaturation;
    private int bloodPressure;
    private int heartRate;

    public Matlab() {
    }

    public Matlab(int oxygenSaturation, int bloodPressure, int heartRate) {
        this.oxygenSaturation = oxygenSaturation;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
    }

    public int getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(int oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public Document toDocument() {
        return new Document()
                .append("oxygenSaturation", oxygenSaturation)
                .append("bloodPresure", bloodPressure)
                .append("hartRate", heartRate);
    }

    public static Matlab fromDocument(Document doc) {
        return new Matlab(
                doc.getInteger("oxygenSaturation"),
                doc.getInteger("bloodPresure"),
                doc.getInteger("hartRate")
        );
    }
}