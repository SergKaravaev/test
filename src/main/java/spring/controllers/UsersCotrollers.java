package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.models.Users;
import spring.repository.UsersRepository;

@Controller
    public class UsersCotrollers {

@Autowired
private UsersRepository usersRepository;

        @GetMapping("/")
        public String home (Model model) {
            return "home";
        }

    @GetMapping("/users")
    public String users (Model model) {
        return "users";
    }

    @PostMapping("/users")
    public String UsersAdd (@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String password, @RequestParam String role, Model model) {
     Users users = new Users(name, surname, email, password, role);
        usersRepository.save(users);
        return "redirect:/";
    }

    }
