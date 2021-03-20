package com.example.indianstates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final StateService stateService;

    public Controller(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/states")
    private List<State> getAllStates() {
        return stateService.findAll();
    }

    @GetMapping(value = "/state")
    private String getSpecificState(@RequestParam(required = false, name = "name", defaultValue = "Maharashtra") String name) {
        return stateService.findByName(name);
    }
}
