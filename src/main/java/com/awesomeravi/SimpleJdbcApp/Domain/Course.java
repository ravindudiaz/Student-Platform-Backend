package com.awesomeravi.SimpleJdbcApp.Domain;

public class Course {
    private Integer course_id;
    private String name;
    private Integer duration_months;

    public Course(Integer course_id, String name, Integer duration_months) {
        this.course_id = course_id;
        this.name = name;
        this.duration_months = duration_months;
    }

    public Course(){}

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration_months() {
        return duration_months;
    }

    public void setDuration_months(Integer duration_months) {
        this.duration_months = duration_months;
    }
}
