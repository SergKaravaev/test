package com.boots.controller;


import com.boots.entity.Users;
import com.boots.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

        @Autowired
        private UsersRepository usersRepository;

        @GetMapping("/users")
        public String users (Model model) {
            return "users";
        }

        @PostMapping("/users")
        public String UsersAdd (@RequestParam String name, @RequestParam String surname, @RequestParam String username, @RequestParam String password, @RequestParam String roles, Model model) {
            Users users = new Users(name, surname, username, password, roles);
            usersRepository.save(users);
            return "redirect:/avto";
        }
    }
