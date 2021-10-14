package com.boots.controller;

import com.boots.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Services;


@Controller
public class ServicesController {

    @Autowired
    private ServicesRepository servicesRepository;

    @GetMapping("/services")
    public String services (Model model) {
        return "services";
    }

    @PostMapping("/services")
    public String ServicesAdd (@RequestParam Long id_jobs, @RequestParam Long id_sto, @RequestParam float services_price, Model model) {
        Services services = new Services(id_jobs, id_sto, services_price);
        servicesRepository.save(services);
        return "redirect:/usersservices";
    }
}
