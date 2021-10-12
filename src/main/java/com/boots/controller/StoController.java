package com.boots.controller;

import com.boots.repository.StoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boots.entity.Sto;


@Controller
public class StoController {

        @Autowired
        private StoRepository stoRepository;

        @GetMapping("/sto")
        public String sto (Model model) {
            return "sto";
        }

        @PostMapping("/sto")
        public String StoAdd (@RequestParam Long id_avto,Model model) {
            Sto sto = new Sto(id_avto);
            stoRepository.save(sto);
            return "redirect:/";
        }
    }
