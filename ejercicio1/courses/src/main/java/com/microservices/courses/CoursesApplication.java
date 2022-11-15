package com.microservices.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.microservices.courses.controller", "com.microservices.courses.service" })
@EnableJpaRepositories(basePackages = {"com.microservices.courses.repository"})
@EntityScan(basePackages = {"com.microservices.courses.model"})
public class CoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesApplication.class, args);
    }

}

