package com.babymonitor.scenario.repository;

import com.babymonitor.scenario.model.Scenario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScenarioRepository extends MongoRepository<Scenario, String> {
}