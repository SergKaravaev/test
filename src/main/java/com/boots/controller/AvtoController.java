package com.boots.controller;

import com.boots.entity.Avto;
import com.boots.repository.AvtoRepository;
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
public class AvtoController {

    @Autowired
    private AvtoRepository avtoRepository;

    @GetMapping("/avto")
    public String avtoAdd (Model model) {
        return "avto/avto";
    }

  @PostMapping("/avto")
    public String avtoAdd (@RequestParam String brant, @RequestParam String models,
                            @RequestParam Long id_users, Model model) {
        Avto avto = new Avto(brant, models, id_users);
        avtoRepository.save(avto);
        return "redirect:/";
    }

    @GetMapping("/avto/{id}")
    public String avtoDetails (@PathVariable(value = "id") long id, Model model) {
        if(!avtoRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Avto> avto = avtoRepository.findById(id);
        ArrayList<Avto> res = new ArrayList<>();
        avto.ifPresent(res::add);
        model.addAttribute("avto", res);
        return "avto/avto-details";
    }

    @GetMapping("/avto/{id}/edit")
    public String avtoEdit (@PathVariable(value = "id") long id, Model model) {
        if(!avtoRepository.existsById(id)){
            return "redirect:/history";
        }
        Optional<Avto> avto = avtoRepository.findById(id);
        ArrayList<Avto> res = new ArrayList<>();
        avto.ifPresent(res::add);
        model.addAttribute("avto", res);
        return "avto/avto-edit";
    }

    @PostMapping("/avto/{id}/edit")
    public String avtoUpdate (@PathVariable(value = "id") long id, @RequestParam String brant, @RequestParam String models,
                               @RequestParam Long id_users, Model model) {
        Avto avto =avtoRepository.findById(id).orElseThrow();
        avto.setBrant(brant);
        avto.setModels(models);
        avto.setId_users(id_users);
        avtoRepository.save(avto);
        return "redirect:/history";
    }

    @PostMapping("/avto/{id}/remove")
    public String avtoDelete (@PathVariable(value = "id") long id, Model model) {
        Avto avto =avtoRepository.findById(id).orElseThrow();
        avtoRepository.delete(avto);
        return "redirect:/history";
    }
}