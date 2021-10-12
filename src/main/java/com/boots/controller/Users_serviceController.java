package com.boots.controller;

import com.boots.entity.Users_service;
import com.boots.repository.Users_serviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Users_serviceController {
    @Autowired
    private Users_serviceRepository users_serviceRepository;

    @GetMapping("/usersservice")
    public String service (Model model) {
        return "usersservice";
    }

    @PostMapping("/usersservice")
    public String ServiceAdd (@RequestParam Long id_users, @RequestParam Long id_service, @RequestParam String work_employee, Model model) {
        Users_service users_service = new Users_service(id_users, id_service, work_employee);
        users_serviceRepository.save(users_service);
        return "redirect:/";
    }
}

