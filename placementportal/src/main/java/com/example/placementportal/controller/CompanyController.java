package com.example.placementportal.controller;
import java.util.List;

import com.example.placementportal.entity.Application;
import com.example.placementportal.entity.Company;
import com.example.placementportal.entity.Job;
import com.example.placementportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:5174")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company) {
        return service.addCompany(company);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return service.getCompanyById(id);
    }

    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable Long id,
                                 @RequestBody Company company) {
        return service.updateCompany(id, company);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        return service.deleteCompany(id);
    }
    @GetMapping("/{companyId}/jobs")
    public List<Job> getCompanyJobs(@PathVariable Long companyId){
        return service.getCompanyJobs(companyId);
    }
    @GetMapping("/{companyId}/applications")
    public List<Application> getApplicants(@PathVariable Long companyId){
        return service.getApplicants(companyId);
    }
 
}
