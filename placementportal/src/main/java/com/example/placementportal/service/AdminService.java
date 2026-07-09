package com.example.placementportal.service;

import com.example.placementportal.dto.DashboardResponse;
import com.example.placementportal.repository.ApplicationRepository;
import com.example.placementportal.repository.CompanyRepository;
import com.example.placementportal.repository.JobRepository;
import com.example.placementportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                studentRepository.count(),
                companyRepository.count(),
                jobRepository.count(),
                applicationRepository.count()
        );
    }
}