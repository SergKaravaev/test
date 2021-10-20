package com.boots.controller;

import com.boots.entity.Sto;
import com.boots.repository.StoRepository;
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
public class StoController {

    @Autowired
    private StoRepository stoRepository;

    @GetMapping("/sto")
    public String stoAdd (Model model) {
        return "sto/sto";
    }

    @PostMapping("/sto")
    public String stodd (@RequestParam Long id_avto, @RequestParam String status, Model model) {
        Sto sto = new Sto(id_avto, status);
        stoRepository.save(sto);
        return "redirect:/";
    }

    @GetMapping("/sto/{id}")
    public String stoDetails (@PathVariable(value = "id") long id, Model model) {
        if(!stoRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Sto> sto = stoRepository.findById(id);
        ArrayList<Sto> res = new ArrayList<>();
        sto.ifPresent(res::add);
        model.addAttribute("sto", res);
        return "sto/sto-details";
    }

    @GetMapping("/sto/{id}/edit")
    public String stoEdit (@PathVariable(value = "id") long id, Model model) {
        if(!stoRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Sto> sto = stoRepository.findById(id);
        ArrayList<Sto> res = new ArrayList<>();
        sto.ifPresent(res::add);
        model.addAttribute("sto", res);
        return "sto/sto-edit";
    }

    @PostMapping("/sto/{id}/edit")
    public String stoUpdate (@PathVariable(value = "id") long id, @RequestParam Long id_avto, @RequestParam String status, Model model) {
        Sto sto =stoRepository.findById(id).orElseThrow();
        sto.setId_avto(id_avto);
        sto.setStatus(status);
        stoRepository.save(sto);
        return "redirect:/history";
    }

    @PostMapping("/sto/{id}/remove")
    public String stoDelete (@PathVariable(value = "id") long id, Model model) {
        Sto sto =stoRepository.findById(id).orElseThrow();
        stoRepository.delete(sto);
        return "redirect:/history";
    }
}