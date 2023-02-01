package com.bolsaideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.app.springbootweb.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"","/","/index","/home"})
    public String index(Model model){
        model.addAttribute("title", "Hola spring framework");
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(Model model){
        User user = new User();
        user.setName("John");
        user.setSurname("Doe");
        model.addAttribute("title", "El nombre del usuario es "+user.getName());
        model.addAttribute("user", user);
        model.addAttribute("surname", user);
        return "profile";
    }
}
