package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;

import java.util.List;

public interface ScenarioService {
    Scenario createScenario(String name);
    Scenario getScenario(Long id);
    List<Scenario> getAllScenarios();
}

