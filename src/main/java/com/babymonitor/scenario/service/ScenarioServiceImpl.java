package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private final List<Scenario> scenarios = new ArrayList<>();

    @Override
    public Scenario createScenario(String name) {
        Scenario scenario = new Scenario();
        scenarios.add(scenario);
        return scenario;
    }

    @Override
    public Scenario getScenario(Long id) {
        return scenarios.stream()
                .filter(lobby -> lobby.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Scenario> getAllScenarios() {
        return scenarios;
    }
}

