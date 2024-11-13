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
    private final RabbitMQSenderService senderService;

    @Autowired
    public ScenarioController(ScenarioService scenarioService, @Nullable RabbitMQSenderService senderService) {
        this.scenarioService = scenarioService;
        this.senderService = senderService;
    }

    @PostMapping
    public Scenario createScenario(@RequestParam String name) {
        return scenarioService.createScenario(name);
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
