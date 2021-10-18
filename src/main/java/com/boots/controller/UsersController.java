package com.boots.controller;

import com.boots.Service.UsersService;
import com.boots.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.util.List;

@Controller
public class UsersController {

    private UsersService usersService = new UsersService();

    @GetMapping("/users")
    public String users(Model model)
    {
        List<Users> users;
        try {
            users = usersService.getAll();
            model.addAttribute("users", users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "users";
    }

    @GetMapping("/users")
    public String usersAdd(Model model) {
        return "users";
    }

    @PostMapping("/users")
    public String UsersAdd(@RequestParam String name, @RequestParam String surname, @RequestParam String username,
                           @RequestParam String password, @RequestParam String roles, Model model) {
        Users users = new Users();
        users.setName(name);
        users.setSurname(surname);
        users.setUsername(username);
        users.setPassword(password);
        users.setRoles(roles);
        try {
            usersService.add(users);
            ;
        } catch (SQLException e) {
            System.out.println("Пользователь не добавился");
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/users/{id}")
    public String UsersDel(@PathVariable(value = "id") Long id, Model model)
    {
        Users users = new Users();
        users.setId(id);
        try {
            usersService.remove(users);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String usersUp(@PathVariable(value = "id") Long id, Model model)
    {
        Users users = new Users();
        users.setId(id);
        try {
            users = usersService.getById(id);

            model.addAttribute("users", users);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не получили пользователя по id");
        }

        return "update";
    }

    @PostMapping("/users/{id}")
    public String usersUpdate(@PathVariable(value = "id") Long id,@RequestParam String name, @RequestParam String surname,
                              @RequestParam String username, @RequestParam String password, @RequestParam String roles, Model model)
    {
        try {
            Users users = new Users();
            users = usersService.getById(id);
            users.setId(id);
            users.setName(name);
            users.setSurname(surname);
            users.setUsername(username);
            users.setPassword(password);
            users.setRoles(roles);

            usersService.update(users);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/users";
    }
}

