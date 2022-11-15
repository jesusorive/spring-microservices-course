package com.microservices.training.model;

import com.microservices.training.TrainingApplication;

public class Course {
    private String code;
    private String name;
    private int duration;
    private double price;

    public Course() {
    }

    public Course(String code, String name, int duration, double price) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public Course(Training training) {
        this.name = training.getCourse();
        this.duration = training.getSubjects() * 10;
        this.price = training.getPrice();
        this.code = this.name.substring(0, 3) + this.duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
