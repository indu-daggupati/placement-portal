package com.example.placementportal.repository;

import com.example.placementportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findAll();
    List<Job> findByCompanyId(Long companyId);

}