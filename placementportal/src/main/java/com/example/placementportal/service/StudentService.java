package com.example.placementportal.service;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.placementportal.jwt.JwtUtil;
import com.example.placementportal.dto.LoginResponse;
import com.example.placementportal.entity.Application;
import com.example.placementportal.entity.Job;
import com.example.placementportal.entity.Student;
import com.example.placementportal.repository.ApplicationRepository;
import com.example.placementportal.repository.JobRepository;
import com.example.placementportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JobRepository jobRepository;

    public Student registerStudent(Student student) {

    student.setPassword(passwordEncoder.encode(student.getPassword()));

    return repository.save(student);
    }
    public List<Job> getAllJobs() {
    return jobRepository.findAll();
    }
    public List<Application> getAppliedJobs(Long studentId) {
    return applicationRepository.findByStudentId(studentId);
    }
    public List<Application> getApplicationStatus(Long studentId) {
    return applicationRepository.findByStudentId(studentId);
    }

public LoginResponse login(String email, String password) {

    Student student = repository.findByEmail(email);

    if (student == null) {
        return new LoginResponse("Email not found", null);
    }

    if (!passwordEncoder.matches(password, student.getPassword())) {
        return new LoginResponse("Invalid Password", null);
    }

    String token = jwtUtil.generateToken(student.getEmail());

    return new LoginResponse("Login Successful", token);
}
}