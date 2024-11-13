package com.babymonitor.scenario.model;

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
}