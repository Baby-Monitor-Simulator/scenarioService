package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;

import java.util.List;

public interface ScenarioService {
    Scenario createScenario(Scenario scenario);
    Scenario getScenario(String id);
    boolean deleteScenario(String id);
    List<Scenario> getAllScenarios();
}

