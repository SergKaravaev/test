package com.boots.controller;

import com.boots.entity.Jobs;
import com.boots.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class JobsController {

    @Autowired
    private JobsRepository jobsRepository;

    @GetMapping("/jobs")
    public String jobsAdd (Model model) {
        return "jobs/jobs";
    }

    @PostMapping("/jobs")
    public String jobsAdd (@RequestParam String type_of_work, @RequestParam float price, Model model) {
        Jobs jobs = new Jobs(type_of_work, price);
        jobsRepository.save(jobs);
        return "redirect:/";
    }

    @GetMapping("/jobs/{id}")
    public String jobsDetails (@PathVariable(value = "id") long id, Model model) {
        if(!jobsRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Jobs> jobs = jobsRepository.findById(id);
        ArrayList<Jobs> res = new ArrayList<>();
        jobs.ifPresent(res::add);
        model.addAttribute("jobs", res);
        return "jobs/jobs-details";
    }

    @GetMapping("/jobs/{id}/edit")
    public String jobsEdit (@PathVariable(value = "id") long id, Model model) {
        if(!jobsRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Jobs> jobs = jobsRepository.findById(id);
        ArrayList<Jobs> res = new ArrayList<>();
        jobs.ifPresent(res::add);
        model.addAttribute("jobs", res);
        return "jobs/jobs-edit";
    }

    @PostMapping("/jobs/{id}/edit")
    public String jobsUpdate (@PathVariable(value = "id") long id, @RequestParam String type_of_work, @RequestParam float price, Model model) {
        Jobs jobs =jobsRepository.findById(id).orElseThrow();
        jobs.setType_of_work(type_of_work);
        jobs.setPrice(price);
        jobsRepository.save(jobs);
        return "redirect:/history";
    }

    @PostMapping("/jobs/{id}/remove")
    public String jobsDelete (@PathVariable(value = "id") long id, Model model) {
        Jobs jobs =jobsRepository.findById(id).orElseThrow();
        jobsRepository.delete(jobs);
        return "redirect:/history";
    }
}