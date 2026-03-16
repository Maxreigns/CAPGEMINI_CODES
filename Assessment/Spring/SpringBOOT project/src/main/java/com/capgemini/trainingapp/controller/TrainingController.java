package com.capgemini.trainingapp.controller;

import com.capgemini.trainingapp.entity.Training;
import com.capgemini.trainingapp.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    TrainingService service;

    @GetMapping("/trainings")
    public List<Training> getTrainings(@RequestParam(required = false) String name) {

        if(name == null) {
            return service.getCurrentAndUpcoming();
        }

        return service.searchCurrentAndUpcoming(name);
    }

    @GetMapping("/trainings/upcoming")
    public List<Training> upcoming(@RequestParam String name) {
        return service.searchUpcoming(name);
    }
}