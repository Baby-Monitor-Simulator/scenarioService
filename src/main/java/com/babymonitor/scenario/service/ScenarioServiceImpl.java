package com.babymonitor.scenario.service;

import com.babymonitor.scenario.model.Scenario;
import com.babymonitor.scenario.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {

    private final ScenarioRepository scenarioRepository;

    @Autowired
    public ScenarioServiceImpl(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    @Override
    public Scenario createScenario(Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    @Override
    public Scenario getScenario(String id) {
        return scenarioRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteScenario(String id) {
        try {
            scenarioRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Scenario> getAllScenarios() {
        return scenarioRepository.findAll();
    }
}

