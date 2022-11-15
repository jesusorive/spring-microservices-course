package com.microservices.training.controller;

import com.microservices.training.model.Training;
import com.microservices.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping(value = "trainings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Training> listAllTrainings() {
        return trainingService.findAll();
    }

    @PostMapping(value = "training", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTraining(@RequestBody Training training) {
        trainingService.create(training);
    }
}
