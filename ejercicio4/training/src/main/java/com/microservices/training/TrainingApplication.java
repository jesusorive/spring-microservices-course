package com.microservices.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
        "com.microservices.training.controller",
        "com.microservices.training.service",
        "com.microservices.training.config"
})
public class TrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        BasicAuthenticationInterceptor authInterceptor =
                new BasicAuthenticationInterceptor("user4", "user4");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(authInterceptor);
        return restTemplate;
    }
}
