package com.boots.controller;

import com.boots.entity.UsersService;
import com.boots.repository.UsersServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UsersServiceController {
    @Autowired
    private UsersServiceRepository usersServiceRepository ;

    @GetMapping("/usersservice")
    public String usersservice (Model model) {
        return "usersservice";
    }

    @PostMapping("/usersservice")
    public String UsersserviceAdd (@RequestParam Long id_users, @RequestParam Long id_service, @RequestParam String work_employee, Model model) {
        UsersService userService = new UsersService(id_users, id_service, work_employee);
        usersServiceRepository.save(userService);
        return "redirect:/";
    }
}

