package com.boots.controller;

import com.boots.Service.ServService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Serv;

import java.sql.Date;
import java.sql.SQLException;


@Controller
public class ServController {
    private ServService servService = new ServService();

    @GetMapping("/serv")
    public String services (Model model) {
        return "serv";
    }

    @PostMapping("/serv")
    public String ServAdd (@RequestParam Long id_jobs, @RequestParam Long id_sto, @RequestParam Date data, @RequestParam float serv_price, Model model) {

        Serv serv = new Serv();
        serv.setId_jobs(id_jobs);
        serv.setId_sto(id_sto);
        serv.setData(data);
        serv.setServ_price(serv_price);

        try {
            servService.add(serv);

        } catch (SQLException e) {
            System.out.println("услуга не добавилась");
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
