package com.boots.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.boots.entity.Users;
import com.boots.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public String usersAdd (Model model) {
        return "users";
    }

    @PostMapping("/users")
    public String usersAdd (@RequestParam String name, @RequestParam String surname,
                            @RequestParam String username,@RequestParam String password,
                            @RequestParam String roles, Model model) {
        Users users = new Users(name, surname, username, password, roles);
        usersRepository.save(users);
        return "redirect:/";
    }

    @GetMapping("/history")
    public String users (Model model) {
        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "history";
    }

    @GetMapping("/users/{id}")
    public String usersDetails (@PathVariable(value = "id") long id, Model model) {
      if(!usersRepository.existsById(id)){
          return "redirect:/history";
      }
        Optional<Users> users = usersRepository.findById(id);
        ArrayList<Users> res = new ArrayList<>();
        users.ifPresent(res::add);
        model.addAttribute("users", res);
        return "users-details";
    }

    @GetMapping("/users/{id}/edit")
    public String usersEdit (@PathVariable(value = "id") long id, Model model) {
        if(!usersRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Users> users = usersRepository.findById(id);
        ArrayList<Users> res = new ArrayList<>();
        users.ifPresent(res::add);
        model.addAttribute("users", res);
        return "users-edit";
    }

    @PostMapping("/users/{id}/edit")
    public String usersUpdate (@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String surname,
                            @RequestParam String username,@RequestParam String password,
                            @RequestParam String roles, Model model) {
        Users users =usersRepository.findById(id).orElseThrow();
        users.setName(name);
        users.setSurname(surname);
        users.setUsername(username);
        users.setPassword(password);
        users.setRoles(roles);
        usersRepository.save(users);
        return "redirect:/history";
    }

    @PostMapping("/users/{id}/remove")
    public String usersDelete (@PathVariable(value = "id") long id, Model model) {
        Users users =usersRepository.findById(id).orElseThrow();
        usersRepository.delete(users);
        return "redirect:/history";
    }
}

