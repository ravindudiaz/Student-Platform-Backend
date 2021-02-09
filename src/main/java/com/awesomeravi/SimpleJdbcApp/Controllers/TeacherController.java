package com.awesomeravi.SimpleJdbcApp.Controllers;

import com.awesomeravi.SimpleJdbcApp.Domain.Teacher;
import com.awesomeravi.SimpleJdbcApp.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/getallteachers")
    public List<Teacher> getAllTeachers(){
        return teacherRepository.getAllTeachers();
    }

    @GetMapping("/getteacherbyid/{uid}")
    public Teacher getTeacherById(@PathVariable Integer uid){
        List<Teacher> teachers=teacherRepository.getTeacherById(uid);
        return teachers.get(0);
    }

    @PostMapping("/addteacher")
    public String addTeacher(@RequestBody Teacher teacher){
        return teacherRepository.addTeacher(teacher);
    }

    @PutMapping("/updateteacher")
    public String updateTeacher(@RequestBody Teacher teacher){
        return teacherRepository.updateTeacher(teacher);
    }

    @DeleteMapping("/deleteteacherbyid/{uid}")
    public String deleteTeacherById(@PathVariable("uid") Integer uid){
        return teacherRepository.deleteTeacherById(uid);
    }

}
