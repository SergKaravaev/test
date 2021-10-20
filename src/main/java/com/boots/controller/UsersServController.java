package com.boots.controller;

import com.boots.entity.UsersServ;
import com.boots.repository.UsersServRepository;
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
public class UsersServController {
    @Autowired
    private UsersServRepository usersServRepository;

    @GetMapping("/usersServ")
    public String usersServAdd (Model model) {
        return "usersServ/usersServ";
    }

    @PostMapping("/usersServ")
    public String usersServAdd (@RequestParam Long id_users, @RequestParam Long id_serv,
                           @RequestParam String work_employee, Model model) {
        UsersServ usersServ = new UsersServ(id_users, id_serv, work_employee);
        usersServRepository.save(usersServ);
        return "redirect:/";
    }

    @GetMapping("/usersServ/{id}")
    public String usersServDetails (@PathVariable(value = "id") long id, Model model) {
        if(!usersServRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<UsersServ> usersServ = usersServRepository.findById(id);
        ArrayList<UsersServ> res = new ArrayList<>();
        usersServ.ifPresent(res::add);
        model.addAttribute("usersServ", res);
        return "usersServ/usersServ-details";
    }

    @GetMapping("/usersServ/{id}/edit")
    public String usersServEdit (@PathVariable(value = "id") long id, Model model) {
        if(!usersServRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<UsersServ> usersServ = usersServRepository.findById(id);
        ArrayList<UsersServ> res = new ArrayList<>();
        usersServ.ifPresent(res::add);
        model.addAttribute("usersServ", res);
        return "usersServ/usersServ-edit";
    }

    @PostMapping("/usersServ/{id}/edit")
    public String usersServUpdate (@PathVariable(value = "id") long id, @RequestParam Long id_users, @RequestParam Long id_serv,
                                   @RequestParam String work_employee, Model model) {
        UsersServ usersServ = usersServRepository.findById(id).orElseThrow();
        usersServ.setId_users(id_users);
        usersServ.setId_serv(id_serv);
        usersServ.setWork_employee(work_employee);
        usersServRepository.save(usersServ);
        return "redirect:/history";
    }

    @PostMapping("/usersServ/{id}/remove")
    public String usersServDelete (@PathVariable(value = "id") long id, Model model) {
        UsersServ usersServ = usersServRepository.findById(id).orElseThrow();
        usersServRepository.delete(usersServ);
        return "redirect:/history";
    }
}

