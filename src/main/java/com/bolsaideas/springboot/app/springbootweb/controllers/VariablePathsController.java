package com.bolsaideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/variables")
public class VariablePathsController {

    @GetMapping({ "", "/" })
    public String index(Model model) {
        model.addAttribute("title", "Enviar parametros de la ruta (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("title", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("result", "el texto enviado por la ruta es: " + text);
        return "variables/see";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
        model.addAttribute("title", "Recibir parametros de la ruta (@PathVariable)");
        model.addAttribute("result",
                "el texto enviado por la ruta es: " + text + " y el numero enviado en el path es: " + number);
        return "variables/see";
    }
}
