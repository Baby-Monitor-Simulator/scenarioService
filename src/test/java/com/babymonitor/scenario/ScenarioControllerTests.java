package com.babymonitor.scenario;

import com.babymonitor.scenario.controller.ScenarioController;
import com.babymonitor.scenario.model.Matlab;
import com.babymonitor.scenario.model.Scenario;
import com.babymonitor.scenario.service.ScenarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ScenarioController.class)
class ScenarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScenarioServiceImpl scenarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenGetAllScenarios_thenReturnJsonArray() throws Exception {
        Scenario scenario1 = new Scenario("testScenario", "testDescription", new Matlab(2,5,7));
        Scenario scenario2 = new Scenario("testScenario2", "testDescription2", new Matlab(6,1,5));
        List<Scenario> allScenarios = Arrays.asList(scenario1, scenario2);

        when(scenarioService.getAllScenarios()).thenReturn(allScenarios);

        mockMvc.perform(get("/scenario/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("testScenario")))
                .andExpect(jsonPath("$[0].description", is("testDescription")))
                .andExpect(jsonPath("$[0].matlab.heartRate", is(7)))
                .andExpect(jsonPath("$[0].matlab.bloodPressure", is(5)))
                .andExpect(jsonPath("$[0].matlab.oxygenSaturation", is(2)))
                .andExpect(jsonPath("$[1].name", is("testScenario2")))
                .andExpect(jsonPath("$[1].description", is("testDescription2")))
                .andExpect(jsonPath("$[1].matlab.heartRate", is(5)))
                .andExpect(jsonPath("$[1].matlab.bloodPressure", is(1)))
                .andExpect(jsonPath("$[1].matlab.oxygenSaturation", is(6)));

    }

    @Test
    void whenGetSpecificResult_thenReturnJson() throws Exception {
        Scenario scenario = new Scenario("gddg67","testScenario", "testDescription", new Matlab(2,5,7));


        when(scenarioService.getScenario("gddg67")).thenReturn(scenario);

        mockMvc.perform(get("/scenario/gddg67")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._id", is("gddg67")))
                .andExpect(jsonPath("$.name", is("testScenario")))
                .andExpect(jsonPath("$.description", is("testDescription")))
                .andExpect(jsonPath("$.matlab.heartRate", is(7)))
                .andExpect(jsonPath("$.matlab.bloodPressure", is(5)))
                .andExpect(jsonPath("$.matlab.oxygenSaturation", is(2)));
    }

    @Test
    void whenGetNonExistingResult_thenReturn404() throws Exception {
        when(scenarioService.getScenario("test")).thenReturn(null);

        mockMvc.perform(get("/scenario/test")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void whenAddNewResult_thenReturnSuccess() throws Exception {
        Scenario scenario = new Scenario("testScenario", "testDescription", new Matlab(2,5,7));

        when(scenarioService.createScenario(any())).thenReturn(scenario);

        mockMvc.perform(post("/scenario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(scenario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("testScenario")))
                .andExpect(jsonPath("$.description", is("testDescription")))
                .andExpect(jsonPath("$.matlab.heartRate", is(7)))
                .andExpect(jsonPath("$.matlab.bloodPressure", is(5)))
                .andExpect(jsonPath("$.matlab.oxygenSaturation", is(2)));
    }

    @Test
    void whenAddNewResultWithInvalidJson_thenReturn400() throws Exception {
        String invalidJson = "{ invalid json }";

        mockMvc.perform(post("/scenario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenGetResultsForUserWithNoResults_thenReturnEmptyArray() throws Exception {
        when(scenarioService.getAllScenarios()).thenReturn(List.of());

        mockMvc.perform(get("/scenario/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void whenAddResultWithNullFields_thenReturnSuccess() throws Exception {
        Scenario scenario = new Scenario("", "", null);

        when(scenarioService.createScenario(any())).thenReturn(scenario);

        mockMvc.perform(post("/scenario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(scenario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("")))
                .andExpect(jsonPath("$.description", is("")))
                .andExpect(jsonPath("$.matlab").doesNotExist());
    }
}
