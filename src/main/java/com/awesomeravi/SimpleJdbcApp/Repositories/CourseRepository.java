package com.awesomeravi.SimpleJdbcApp.Repositories;

import com.awesomeravi.SimpleJdbcApp.Domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Course> courseRowMapper = (rs,rowNum)->{
      Course course = new Course();
      course.setCourse_id(rs.getInt("course_id"));
      course.setName(rs.getString("name"));
      course.setDuration_months(rs.getInt("duration_months"));
      return course;
    };

    public List<Course> getAllCourses(){
        String sql = "SELECT * FROM course";
        List<Course> courses= jdbcTemplate.query(sql,courseRowMapper);
        return courses;
    }

    public List<Course> getCourseById(Integer course_id){
        String sql = "SELECT * FROM course WHERE course_id=?";
        List<Course> courses = jdbcTemplate.query(sql,courseRowMapper,course_id);
        return courses;
    }

    public String addCourse(Course course){
        String sql = "INSERT INTO course(name,duration_months) VALUES(?,?)";
        int added = jdbcTemplate.update(sql, course.getName(),course.getDuration_months());
        if(added==1)
            return "Course successfully added";
        else
            return "Adding unsuccessful";
    }

    public String updateCourse(Course course){
        String sql = "UPDATE course SET name=?, email=? WHERE course_id=?";
        int updated = jdbcTemplate.update(sql, course.getName(),course.getDuration_months(), course.getCourse_id());
        if(updated==1)
            return "Successfullu updated course";
        else
            return "Update unsuccessful";
    }

    public String deleteCourseById(Integer id){
        String sql = "DELETE FROM course WHERE course_id=?";
        int deleted = jdbcTemplate.update(sql,id);
        if(deleted==1)
            return "Course deleted successfully";
        else
            return "Deleteion unsuccessful";
    }
}
