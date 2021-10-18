package com.boots.controller;


import com.boots.Service.StoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Sto;

import java.sql.SQLException;


@Controller
public class StoController {

    private StoService stoService = new StoService();

    @GetMapping("/sto")
    public String sto (Model model) {
        return "sto";
    }

    @PostMapping("/sto")
    public String StoAdd (@RequestParam Long id_avto, Model model) {

        Sto sto = new Sto();
        sto.setId_avto(id_avto);

        try {
            stoService.add(sto);

        } catch (SQLException e) {
            System.out.println("сто не добавилось");
            e.printStackTrace();
        }
        return "redirect:/";
    }
    }
