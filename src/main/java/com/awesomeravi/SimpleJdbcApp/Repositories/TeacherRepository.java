package com.awesomeravi.SimpleJdbcApp.Repositories;

import com.awesomeravi.SimpleJdbcApp.Domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<Teacher> teacherRowMapper = (rs, rowNum) ->{
        Teacher teacher = new Teacher();
        teacher.setUid(rs.getInt("uid"));
        teacher.setName(rs.getString("name"));
        teacher.setCourseId(rs.getInt("course_id"));
        teacher.setEmail(rs.getString("email"));
        return teacher;
    };

    public List<Teacher> getAllTeachers(){
        String sql = "SELECT * FROM teacher";
        List<Teacher> teachers = jdbcTemplate.query(sql,teacherRowMapper);
        return teachers;
    }

    public List<Teacher> getTeacherById(Integer uid){
        String sql="SELECT * FROM teacher WHERE uid=?";
        List<Teacher> teachers = jdbcTemplate.query(sql,teacherRowMapper,uid);
        return teachers;
    }

    public String addTeacher(Teacher teacher){
        String sql = "INSERT INTO teacher(name,course_id,email) VALUES(?,?,?)";
        int added = jdbcTemplate.update(sql,teacher.getName(),teacher.getCourseId(),teacher.getEmail());
        System.out.println(added);
        if(added==1)
            return "Added user "+teacher.getName()+" created";
        else
            return "Adding user unsuccessful";
    }

    public String updateTeacher(Teacher teacher){
        String sql = "UPDATE teacher SET name=?, courseId=?,courseId=?, email=?  WHERE uid=?";
        int updated = jdbcTemplate.update(sql, teacher.getName(),teacher.getCourseId(),teacher.getCourseId(),teacher.getEmail());
        if(updated==1)
            return "Updated user "+ teacher.getUid().toString()+" "+teacher.getName();
        else
            return "Update unsuccessful";
    }

    public String deleteTeacherById(Integer uid){
        String sql = "DELETE FROM teacher WHERE uid=?";
        int deleted=jdbcTemplate.update(sql, uid);
        if(deleted==1)
            return "Delete successful";
        else
            return "Delete unsuccessful";
    }
}
