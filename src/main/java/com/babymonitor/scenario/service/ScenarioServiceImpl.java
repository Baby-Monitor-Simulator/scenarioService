package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private final List<Scenario> scenarios = new ArrayList<>();

    @Override
    public Scenario createScenario(Scenario scenario) {
        // todo add to data base
        scenarios.add(scenario);
        return scenario;
    }

    @Override
    public Scenario getScenario(Long id) {
        return scenarios.stream()
                .filter(scenario -> scenario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteScenario(Long id) {
        // todo deleted from database
        return scenarios.removeIf(lobby -> lobby.getId().equals(id));
    }

    @Override
    public List<Scenario> getAllScenarios() {
        // todo get form scenario
        return scenarios;
    }
}

