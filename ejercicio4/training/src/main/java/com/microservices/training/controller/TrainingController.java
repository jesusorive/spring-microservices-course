package com.microservices.training.controller;

import com.microservices.training.model.Training;
import com.microservices.training.service.TrainingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Controller with all trainings' operations.")
@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @ApiOperation("Returns the list of all trainings.")
    @GetMapping(value = "trainings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Training> listAllTrainings() {
        return trainingService.findAll();
    }

    @ApiOperation("Creates the training received in the request body.")
    @PostMapping(value = "training", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTraining(
            @ApiParam("JSON with the training to be created.")
            @RequestBody Training training) {
        trainingService.create(training);
    }
}
