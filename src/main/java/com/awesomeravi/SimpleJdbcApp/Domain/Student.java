package com.awesomeravi.SimpleJdbcApp.Domain;

public class Student {
    private Integer uid;
    private String email;
    private String name;

    public Student(){}

    public Student(Integer uid, String email, String name) {
        this.uid = uid;
        this.email = email;
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
