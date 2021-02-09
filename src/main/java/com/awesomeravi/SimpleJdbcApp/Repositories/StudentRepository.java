package com.awesomeravi.SimpleJdbcApp.Repositories;

import com.awesomeravi.SimpleJdbcApp.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //rs = Result Set
    RowMapper<Student> studentRowMapper = (rs, rowNum)->{
        Student student =new Student();
        student.setUid(rs.getInt("uid"));
        student.setEmail(rs.getString("email"));
        student.setName(rs.getString("name"));
        return student;
    };

    public List<Student> getAllStudents(){
        List<Student> studentNameList = new ArrayList<Student>();
        studentNameList.addAll(jdbcTemplate.query("SELECT * FROM student",studentRowMapper));
        return studentNameList;
    }

    public List<Student> getStudentById(Integer uid){
        String sql = "SELECT * FROM student WHERE uid=?";
        List<Student> students = jdbcTemplate.query(sql,studentRowMapper,uid);
        return students;
    }

    public String addStudent(Student student){
        String insertQuery = "insert into student(email,name) values (?,?)";
        jdbcTemplate.update(insertQuery, student.getEmail(), student.getName());
        return "Student "+student.getEmail()+" "+student.getName()+" "+"created.";
    }

    public Student updateStudent(Student student){
        String updateQuery = "update student set email=?, name=? where uid=?";
        jdbcTemplate.update(updateQuery,student.getEmail(),student.getName(),student.getUid());
        return student;
    }

    public String deleteStudentById(Integer uid){
        String deleteQuery = "delete from student where uid=?";
        int deleted = jdbcTemplate.update(deleteQuery,uid);
        if(deleted==0)
            return "Deleted student "+uid.toString();
        else
            return "Delete unsuccessful.";
    }
}
