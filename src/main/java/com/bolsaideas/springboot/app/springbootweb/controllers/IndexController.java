package com.bolsaideas.springboot.app.springbootweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.app.springbootweb.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${text.indexController.index.title}")
    private String indexText;

    @Value("${text.indexController.profile.title}")
    private String profileText;

    @Value("${text.indexController.list.title}")
    private String listText;

    @GetMapping({ "", "/", "/index", "/home" })
    public String index(Model model) {
        model.addAttribute("title", indexText);
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        User user = new User();
        user.setName("John");
        user.setSurname("Doe");
        user.setEmail("john@doe.com");
        model.addAttribute("title", profileText + user.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user-list")
    public String list(Model model) {
        model.addAttribute("title", listText);
        return "user-list";
    }

    /**
     * con esta manera podemos retornar usuarios en diferentes vistas
     * 
     * @return
     */
    @ModelAttribute("users")
    public List<User> setUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", "john@doe.com"));
        users.add(new User("Jane", "Doe", "jane@doe.com"));
        users.add(new User("Tornado", "Doe", "tornado@doe.com"));
        return users;
    }
}
