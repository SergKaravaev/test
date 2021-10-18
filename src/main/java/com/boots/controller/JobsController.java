package com.boots.controller;

import com.boots.Service.JobsService;
import com.boots.entity.Jobs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class JobsController {

    private JobsService jobsService = new JobsService();

    @GetMapping("/jobs")
    public String jobs (Model model) {
        return "jobs";
    }

    @PostMapping("/jobs")
    public String JobsAdd (@RequestParam String type_of_work, @RequestParam float price, Model model) {

        Jobs jobs = new Jobs();
        jobs.setType_of_work(type_of_work);
        jobs.setPrice(price);

        try {
            jobsService.add(jobs);

        } catch (SQLException e) {
            System.out.println("работа не добавилась");
            e.printStackTrace();
        }
        return "redirect:/";
    }
}


