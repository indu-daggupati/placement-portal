package com.example.placementportal.service;

import com.example.placementportal.entity.Application;
import com.example.placementportal.entity.Job;
import com.example.placementportal.entity.Student;
import com.example.placementportal.repository.ApplicationRepository;
import com.example.placementportal.repository.JobRepository;
import com.example.placementportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobRepository jobRepository;

    public Application applyJob(Long studentId, Long jobId) {

        Student student = studentRepository.findById(studentId).orElse(null);

        Job job = jobRepository.findById(jobId).orElse(null);

        if(student == null || job == null){
            return null;
        }

        Application application = new Application();

        application.setStudent(student);
        application.setJob(job);

        application.setAppliedDate("2026-07-08");

        application.setStatus("Applied");

        return applicationRepository.save(application);
    }
    public Application updateStatus(Long applicationId, String status){

    Application application =
            applicationRepository.findById(applicationId).orElse(null);

    if(application == null){
        return null;
    }

    application.setStatus(status);

    return applicationRepository.save(application);
}
public List<Application> getApplicationsByStudent(Long studentId) {
    return applicationRepository.findByStudentId(studentId);
}

}