package com.boots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Jobs;
import com.boots.repository.JobsRepository;

@Controller
public class JobsController {

        @Autowired
        private JobsRepository jobsRepository;

        @GetMapping("/jobs")
        public String jobs(Model model) {
            return "jobs";
        }

        @PostMapping("/jobs")
        public String JobsAdd(@RequestParam String type_of_work, @RequestParam float price, Model model) {
            Jobs jobs = new Jobs(type_of_work, price);
            jobsRepository.save(jobs);
            return "redirect:/service";
        }
    }


