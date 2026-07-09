package com.example.placementportal.service;
import java.util.List;
import java.util.Optional;

import com.example.placementportal.entity.Application;
import com.example.placementportal.entity.Company;
import com.example.placementportal.entity.Job;
import com.example.placementportal.repository.ApplicationRepository;
import com.example.placementportal.repository.CompanyRepository;
import com.example.placementportal.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company addCompany(Company company) {
        return repository.save(company);
    }
    public List<Company> getAllCompanies() {
    return repository.findAll();
    }
    public Company getCompanyById(Long id) {

    Optional<Company> company = repository.findById(id);

    if (company.isPresent()) {
        return company.get();
    }

    return null;
    }
    public Company updateCompany(Long id, Company updatedCompany) {

    Company company = repository.findById(id).orElse(null);

    if (company == null) {
        return null;
    }

    company.setCompanyName(updatedCompany.getCompanyName());
    company.setLocation(updatedCompany.getLocation());
    company.setPackageOffered(updatedCompany.getPackageOffered());
    company.setEligibilityCgpa(updatedCompany.getEligibilityCgpa());
    company.setJobRole(updatedCompany.getJobRole());
    company.setDescription(updatedCompany.getDescription());

    return repository.save(company);
    }
    public String deleteCompany(Long id) {

    Company company = repository.findById(id).orElse(null);

    if (company == null) {
        return "Company Not Found";
    }

    repository.deleteById(id);

    return "Company Deleted Successfully";
}
@Autowired
private JobRepository jobRepository;

public List<Job> getCompanyJobs(Long companyId){
    return jobRepository.findByCompanyId(companyId);
}
@Autowired
private ApplicationRepository applicationRepository;

public List<Application> getApplicants(Long companyId){
    return applicationRepository.findByJobCompanyId(companyId);
}
}