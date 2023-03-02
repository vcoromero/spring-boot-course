package com.bolsaideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

    @GetMapping({ "", "/" })
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "text", required = false, defaultValue = "default") String text,
            Model model) {
        model.addAttribute("result", "El texto enviado es: " + text);
        return "params/see";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam() String greeting, @RequestParam() Integer number,
            Model model) {
        model.addAttribute("result", "El texto enviado es: " + greeting + "' y el numero es '" + number + "'");
        return "params/see";
    }
    
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (Exception e) {
            number = 0;
        }
        model.addAttribute("result", "El texto enviado es: " + greeting + "' y el numero es '" + number + "'");
        return "params/see";
    }

}
