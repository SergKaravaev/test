package com.boots.controller;

import com.boots.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Service;


@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/service")
    public String service (Model model) {
        return "service";
    }

    @PostMapping("/service")
    public String ServiceAdd (@RequestParam Long id_jobs, @RequestParam Long id_sto, @RequestParam float service_price, Model model) {
        Service service = new Service(id_jobs, id_sto, service_price);
        serviceRepository.save(service);
        return "redirect:/";
    }
}
