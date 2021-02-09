package com.awesomeravi.SimpleJdbcApp.Domain;

public class Teacher {
    private Integer uid;
    private String name;
    private Integer courseId;
    private String email;

    public Teacher(Integer uid, String name, Integer courseId, String email) {
        this.uid = uid;
        this.name = name;
        this.courseId = courseId;
        this.email = email;
    }

    public Teacher(){}

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
