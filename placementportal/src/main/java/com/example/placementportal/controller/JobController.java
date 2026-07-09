package com.example.placementportal.controller;
import java.util.List;
import com.example.placementportal.entity.Job;
import com.example.placementportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/add/{companyId}")
    public Job addJob(@PathVariable Long companyId,
                      @RequestBody Job job) {

        return service.addJob(companyId, job);
    }
    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return service.getAllJobs();
    }
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return service.getJobById(id);
    }
    @PutMapping("/update/{id}")
    public Job updateJob(@PathVariable Long id,
                        @RequestBody Job job) {

        return service.updateJob(id, job);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        return service.deleteJob(id);
    }
}