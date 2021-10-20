package com.boots.controller;

import com.boots.entity.*;
import com.boots.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AvtoRepository avtoRepository;
    @Autowired
    private StoRepository stoRepository;
    @Autowired
    private JobsRepository jobsRepository;
    @Autowired
    private ServRepository servRepository;
    @Autowired
    private UsersServRepository usersServRepository;

    @GetMapping( "/history")
    public String history (Model model) {

        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);

        Iterable<Avto> avto = avtoRepository.findAll();
        model.addAttribute("avto", avto);

        Iterable<Sto> sto = stoRepository.findAll();
        model.addAttribute("sto", sto);

        Iterable<Jobs> jobs = jobsRepository.findAll();
        model.addAttribute("jobs", jobs);

        Iterable<Serv> serv = servRepository.findAll();
        model.addAttribute("serv", serv);

        Iterable<UsersServ> usersServ = usersServRepository.findAll();
        model.addAttribute("usersServ", usersServ);

        return "history";
    }
}
