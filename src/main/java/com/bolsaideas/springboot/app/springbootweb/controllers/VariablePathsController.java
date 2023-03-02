package com.bolsaideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/variables")
public class VariablePathsController {

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("title", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("result", "el texto enviado por la ruta es: " + text);
        return "variables/see";
    }
}
