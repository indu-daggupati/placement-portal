package com.example.placementportal.controller;
import com.example.placementportal.dto.LoginRequest;
import com.example.placementportal.dto.LoginResponse;
import com.example.placementportal.entity.Application;
import com.example.placementportal.entity.Job;
import com.example.placementportal.entity.Student;
import com.example.placementportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public Student register(
            @RequestBody Student student) {

        return service.registerStudent(student);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return service.login(
                request.getEmail(),
                request.getPassword());
    }
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return service.getAllJobs();
    }
    @GetMapping("/applied/{studentId}")
    public List<Application> getAppliedJobs(@PathVariable Long studentId) {
        return service.getAppliedJobs(studentId);
    }
    @GetMapping("/status/{studentId}")
    public List<Application> getApplicationStatus(@PathVariable Long studentId) {
        return service.getApplicationStatus(studentId);
    }
}