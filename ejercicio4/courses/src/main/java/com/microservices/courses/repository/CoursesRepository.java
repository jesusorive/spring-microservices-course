package com.microservices.courses.repository;

import com.microservices.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, String> {
    List<Course> findByPriceBetween(double minPrice, double maxPrice);
}
