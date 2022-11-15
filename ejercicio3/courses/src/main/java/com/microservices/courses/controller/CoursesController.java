package com.microservices.courses.controller;

import com.microservices.courses.model.Course;
import com.microservices.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> listAllCourses() {
        return coursesService.findAll();
    }

    @PostMapping(value = "course",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(@RequestBody Course course) {
        return coursesService.create(course);
    }

    @DeleteMapping(value = "course/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> deleteCourse(@PathVariable("code") String code) {
        return coursesService.delete(code);
    }

    @PutMapping(value = "course/{code}/{duration}")
    public void updateCourseDuration(@PathVariable("code") String code, @PathVariable("duration") int duration) {
        coursesService.updateDuration(code, duration);
    }

    @GetMapping(value = "course/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findCourse(@PathVariable("code") String code) {
        return coursesService.findByCode(code);
    }

    @GetMapping(value = "coursesbypricerange/{minPrice}/{maxPrice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCoursesByPriceRange(@PathVariable("minPrice") double minPrice, @PathVariable("maxPrice") double maxPrice) {
        return coursesService.findByPriceRange(minPrice, maxPrice);
    }
}
