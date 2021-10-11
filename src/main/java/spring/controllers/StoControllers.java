package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.models.Sto;
import spring.repository.StoRepository;


@Controller
public class StoControllers {

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
