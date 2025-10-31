package org.springmix.webapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmix.webapp.data.service.StaffService;

@Controller
@RequestMapping("/staff")

public class StaffController {
    private final StaffService StaffService;

    public StaffController(StaffService staffService) {
        this.StaffService = staffService;
    }

    @GetMapping
    public String getStaffPage(Model model) {
        model.addAttribute("staff", this.StaffService.getAllStaff());
        return "staff";
    }
}
