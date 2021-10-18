package com.boots.controller;

import com.boots.Service.UsersServService;
import com.boots.entity.UsersServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;


@Controller
public class UsersServController {

    private UsersServService usersServService = new UsersServService();

    @GetMapping("/usersServ")
    public String usersServ (Model model) {
        return "usersServ";
    }

    @PostMapping("/usersServ")
    public String UsersServAdd (@RequestParam Long id_users, @RequestParam Long id_serv,
                                    @RequestParam String work_employee, Model model) {

        UsersServ usersServ = new UsersServ();

        usersServ.setId_users(id_users);
        usersServ.setId_serv(id_serv);
        usersServ.setWork_employee(work_employee);

        try {
            usersServService.add(usersServ);

        } catch (SQLException e) {
            System.out.println("пользователь-услуга не добавилось");
            e.printStackTrace();
        }
        return "redirect:/";
    }
}

