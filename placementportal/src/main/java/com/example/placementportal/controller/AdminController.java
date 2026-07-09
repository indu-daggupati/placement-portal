package com.example.placementportal.controller;

import com.example.placementportal.dto.DashboardResponse;
import com.example.placementportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {

        return adminService.getDashboard();
    }
}