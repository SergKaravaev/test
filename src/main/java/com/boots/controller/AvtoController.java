package com.boots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Avto;
import com.boots.repository.AvtoRepository;

@Controller
public class AvtoController {

    @Autowired
    private AvtoRepository avtoRepository;

    @GetMapping("/avto")
    public String avto (Model model) {
        return "avto";
    }

    @PostMapping("/avto")
    public String AvtoAdd (@RequestParam String brant, @RequestParam String models, @RequestParam Long id_users, Model model) {
        Avto avto = new Avto(brant, models, id_users);
        avtoRepository.save(avto);
        return "redirect:/";
    }
}