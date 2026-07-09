package com.example.placementportal.service;
import java.util.List;
import com.example.placementportal.entity.Company;
import com.example.placementportal.entity.Job;
import com.example.placementportal.repository.CompanyRepository;
import com.example.placementportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;
    public List<Job> getAllJobs() {
    return jobRepository.findAll();
    }
    public Job getJobById(Long id) {
    return jobRepository.findById(id).orElse(null);
    }
    public Job updateJob(Long id, Job updatedJob) {

    Job existingJob = jobRepository.findById(id).orElse(null);

    if (existingJob == null) {
        return null;
    }

    existingJob.setJobTitle(updatedJob.getJobTitle());
    existingJob.setDescription(updatedJob.getDescription());
    existingJob.setSalary(updatedJob.getSalary());
    existingJob.setLocation(updatedJob.getLocation());
    existingJob.setLastDate(updatedJob.getLastDate());

    return jobRepository.save(existingJob);
    }
    public String deleteJob(Long id) {

    Job job = jobRepository.findById(id).orElse(null);

    if (job == null) {
        return "Job Not Found";
    }

    jobRepository.delete(job);

    return "Job Deleted Successfully";
    }


    public Job addJob(Long companyId, Job job) {

        
    Company company = companyRepository.findById(companyId).orElse(null);

    if (company == null) {
        System.out.println("Company Not Found");
        return null;
    }

    System.out.println(company.getCompanyName());

    job.setCompany(company);

    System.out.println("Before save");

    Job savedJob = jobRepository.save(job);

    System.out.println("After save");
    System.out.println("Saved Job ID: " + savedJob.getId());

    return savedJob;
    }
}