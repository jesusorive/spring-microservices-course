package com.microservices.courses.controller;

import com.microservices.courses.model.Course;
import com.microservices.courses.service.CoursesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Controller with all courses' operations.")
@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @ApiOperation("Returns the list of all courses.")
    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> listAllCourses() {
        return coursesService.findAll();
    }

    @ApiOperation("Creates the course received in the request body.")
    @PostMapping(value = "course",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(
            @ApiParam("JSON with the course to be created.")
            @RequestBody Course course) {
        return coursesService.create(course);
    }

    @ApiOperation("Deletes de course by the given code.")
    @DeleteMapping(value = "course/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> deleteCourse(
            @ApiParam("Code of the course to be deleted.")
            @PathVariable("code") String code) {
        return coursesService.delete(code);
    }

    @ApiOperation("Updates a course duration.")
    @PutMapping(value = "course/{code}/{duration}")
    public void updateCourseDuration(
            @ApiParam("Code of the course to be updated.")
            @PathVariable("code") String code,
            @ApiParam("Duration of the course to be updated.")
            @PathVariable("duration") int duration) {
        coursesService.updateDuration(code, duration);
    }

    @ApiOperation("Finds courses by code.")
    @GetMapping(value = "course/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findCourse(
            @ApiParam("Code of the searched course.")
            @PathVariable("code") String code) {
        return coursesService.findByCode(code);
    }

    @ApiOperation("Finds courses by price range.")
    @GetMapping(value = "coursesbypricerange/{minPrice}/{maxPrice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCoursesByPriceRange(
            @ApiParam("Min searched courses price.")
            @PathVariable("minPrice") double minPrice,
            @ApiParam("Max searched courses price.")
            @PathVariable("maxPrice") double maxPrice) {
        return coursesService.findByPriceRange(minPrice, maxPrice);
    }
}
