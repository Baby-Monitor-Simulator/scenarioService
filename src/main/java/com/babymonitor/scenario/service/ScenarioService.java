package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;

import java.util.List;

public interface ScenarioService {
    Scenario createScenario(Scenario scenario);
    Scenario getScenario(Long id);
    boolean deleteScenario(Long id);
    List<Scenario> getAllScenarios();
}

