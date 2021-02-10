package com.awesomeravi.SimpleJdbcApp.Controllers;

import com.awesomeravi.SimpleJdbcApp.Domain.Student;
import com.awesomeravi.SimpleJdbcApp.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getallstudents")
    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    @GetMapping("/getstudentbyid/{uid}")
    public Student student(@PathVariable("uid") Integer uid){
        List<Student> students = studentRepository.getStudentById(uid);
        return students.get(0);
    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student student){
        return studentRepository.addStudent(student);
    }

    @PutMapping("/updatestudent")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.updateStudent(student);
    }

    @DeleteMapping("/deletestudent/{uid}")
    public String deleteStudentById(@PathVariable("uid") Integer id){
        return studentRepository.deleteStudentById(id);
    }
}
