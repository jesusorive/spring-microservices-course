package com.microservices.courses.service;

import com.microservices.courses.model.Course;
import com.microservices.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    public List<Course> findAll() {
        return coursesRepository.findAll();
    }

    public List<Course> create(Course course) {
        coursesRepository.save(course);
        return coursesRepository.findAll();
    }

    public List<Course> delete(String code) {
        coursesRepository.deleteById(code);
        return coursesRepository.findAll();
    }

    public void updateDuration(String code, int duration) {
        coursesRepository.findById(code).ifPresent(c -> {
            c.setDuration(duration);
            coursesRepository.save(c);
        });
    }

    public Course findByCode(String code) {
        return coursesRepository.findById(code).orElse(null);
    }

    public List<Course> findByPriceRange(double minPrice, double maxPrice) {
        return coursesRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
