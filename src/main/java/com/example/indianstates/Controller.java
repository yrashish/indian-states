package com.example.indianstates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final StateService stateService;

    public Controller(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/states")
    private List<State> getAllStates(){
        return stateService.findAll();
    }
}
