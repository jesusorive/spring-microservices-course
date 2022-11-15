package com.microservices.training.service;

import com.microservices.training.model.Course;
import com.microservices.training.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrainingService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${microservices.courses.url}")
    private String coursesServiceURL;

    public List<Training> findAll() {
        Course[] courses = restTemplate.getForObject(coursesServiceURL + "/courses", Course[].class);
        return courses == null ?
                Collections.emptyList() :
                Arrays.stream(courses).map(c -> new Training(c)).collect(Collectors.toList());
    }

    public void create(Training training) {
        Course newCourse = new Course(training);
        Course existingCourse = restTemplate.getForObject(
                coursesServiceURL + "/course/" + newCourse.getCode(), Course.class);
        if(existingCourse == null) restTemplate.postForLocation(coursesServiceURL + "/course", newCourse);
    }
}
