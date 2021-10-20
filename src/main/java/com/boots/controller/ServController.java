package com.boots.controller;

import com.boots.entity.Serv;
import com.boots.repository.ServRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ServController {

    @Autowired
    private ServRepository servRepository;

    @GetMapping("/serv")
    public String servAdd (Model model) {
        return "serv/serv";
    }

    @PostMapping("/serv")
    public String servAdd (@RequestParam Long id_jobs, @RequestParam Long id_sto,
                           @RequestParam Date data, @RequestParam float serv_price, Model model) {
        Serv serv = new Serv(id_jobs, id_sto, data, serv_price);
        servRepository.save(serv);
        return "redirect:/";
    }

    @GetMapping("/serv/{id}")
    public String servDetails (@PathVariable(value = "id") long id, Model model) {
        if(!servRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Serv> serv = servRepository.findById(id);
        ArrayList<Serv> res = new ArrayList<>();
        serv.ifPresent(res::add);
        model.addAttribute("serv", res);
        return "serv/serv-details";
    }

    @GetMapping("/serv/{id}/edit")
    public String servEdit (@PathVariable(value = "id") long id, Model model) {
        if(!servRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Serv> serv = servRepository.findById(id);
        ArrayList<Serv> res = new ArrayList<>();
        serv.ifPresent(res::add);
        model.addAttribute("serv", res);
        return "serv/serv-edit";
    }

    @PostMapping("/serv/{id}/edit")
    public String servUpdate (@PathVariable(value = "id") long id, @RequestParam Long id_jobs, @RequestParam Long id_sto,
                              @RequestParam Date data, @RequestParam float serv_price, Model model) {
        Serv serv =servRepository.findById(id).orElseThrow();
        serv.setId_jobs(id_jobs);
        serv.setId_sto(id_sto);
        serv.setData(data);
        serv.setServ_price(serv_price);
        servRepository.save(serv);
        return "redirect:/history";
    }

    @PostMapping("/serv/{id}/remove")
    public String servDelete (@PathVariable(value = "id") long id, Model model) {
        Serv serv = servRepository.findById(id).orElseThrow();
        servRepository.delete(serv);
        return "redirect:/history";
    }
}