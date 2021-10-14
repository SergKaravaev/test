package com.boots.controller;

import com.boots.entity.UsersServices;
import com.boots.repository.UsersServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsersServicesController {
    @Autowired
    private UsersServicesRepository usersServicesRepository ;

    @GetMapping("/usersservices")
    public String usersservices (Model model) {
        return "usersservices";
    }

    @PostMapping("/usersservices")
    public String UsersservicesAdd (@RequestParam Long id_users, @RequestParam Long id_services, @RequestParam String work_employee, Model model) {
        UsersServices userServices = new UsersServices(id_users, id_services, work_employee);
        usersServicesRepository.save(userServices);
        return "redirect:/";
    }
}

