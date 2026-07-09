package com.example.placementportal.controller;

import com.example.placementportal.entity.Application;
import com.example.placementportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @PostMapping("/apply/{studentId}/{jobId}")
    public Application applyJob(@PathVariable Long studentId,
                                @PathVariable Long jobId) {

        return service.applyJob(studentId, jobId);
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getApplications(@PathVariable Long studentId) {
        return service.getApplicationsByStudent(studentId);
    }
}