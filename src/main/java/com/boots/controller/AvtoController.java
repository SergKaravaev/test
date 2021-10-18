package com.boots.controller;

import com.boots.Service.AvtoService;
import com.boots.Service.UsersService;
import com.boots.entity.Avto;
import com.boots.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class AvtoController {

    private AvtoService avtoService = new AvtoService();

    @GetMapping("/avto")
    public String avto (Model model) {
        return "avto";
    }

  @PostMapping("/avto")
    public String AvtoAdd (@RequestParam String brant, @RequestParam String models, @RequestParam Long id_users, Model model) {

        Avto avto = new Avto();
      avto.setBrant(brant);
      avto.setModels(models);
      avto.setId_users(id_users);

        try {
            avtoService.add(avto);

        } catch (SQLException e) {
            System.out.println("машина не добавилась");
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
