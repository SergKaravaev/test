package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.models.Users;
import spring.repository.UsersRepository;

@Controller
    public class MainCotrollers {

@Autowired
private UsersRepository usersRepository;

        @GetMapping("/")
        public String home (Model model) {
            Iterable<Users> users = usersRepository.findAll();
            model.addAttribute("users", users);
            return "home";

        }

    }
