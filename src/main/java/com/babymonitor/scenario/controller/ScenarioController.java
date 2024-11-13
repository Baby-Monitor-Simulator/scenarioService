package com.babymonitor.scenario.controller;

import com.babymonitor.scenario.model.Scenario;
import com.babymonitor.scenario.service.RabbitMQSenderService;
import com.babymonitor.scenario.service.ScenarioService;
import io.micrometer.common.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenario")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @Autowired
    public ScenarioController(ScenarioService scenarioService, @Nullable RabbitMQSenderService senderService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping
    public Scenario createScenario(@RequestBody Scenario scenario) {
        return scenarioService.createScenario(scenario);
    }

    @DeleteMapping
    public boolean deleteScenario(@RequestParam long id) {
        return scenarioService.deleteScenario(id);
    }

    @GetMapping("/{id}")
    public Scenario getScenario(@PathVariable Long id) {
        return scenarioService.getScenario(id);
    }

    @GetMapping
    public List<Scenario> getAllScenarios() {
        return scenarioService.getAllScenarios();
    }
}
