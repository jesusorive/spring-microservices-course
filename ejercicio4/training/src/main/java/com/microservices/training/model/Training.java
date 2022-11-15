package com.microservices.training.model;

public class Training {

    private String course;
    private int subjects;
    private double price;

    public Training() {
    }

    public Training(String course, int subjects, double price) {
        this.course = course;
        this.subjects = subjects;
        this.price = price;
    }

    public Training(Course course) {
        this.course = course.getName();
        this.subjects = course.getDuration() >= 50 ? 10 : 5;
        this.price = course.getPrice();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSubjects() {
        return subjects;
    }

    public void setSubjects(int subjects) {
        this.subjects = subjects;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
