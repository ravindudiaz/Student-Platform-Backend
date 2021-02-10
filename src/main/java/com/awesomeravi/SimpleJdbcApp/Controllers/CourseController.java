package com.awesomeravi.SimpleJdbcApp.Controllers;

import com.awesomeravi.SimpleJdbcApp.Domain.Course;
import com.awesomeravi.SimpleJdbcApp.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/getallcourses")
    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    @GetMapping("/getcoursebyid/{course_id}")
    public Course getCourseById(@PathVariable("course_id") Integer course_id){
        List<Course> courses = courseRepository.getCourseById(course_id);
        return courses.get(0);
    }

    @PostMapping("/addcourse")
    public String addCourse(@RequestBody Course course){
        return courseRepository.addCourse(course);
    }

    @PutMapping("/updatecourse")
    public String updateCourse(@RequestBody Course course){
        return courseRepository.updateCourse(course);
    }

    @DeleteMapping("/deletecoursebyid/{course_id}")
    public String deleteCourseById(@PathVariable Integer course_id){
        return courseRepository.deleteCourseById(course_id);
    }
}
