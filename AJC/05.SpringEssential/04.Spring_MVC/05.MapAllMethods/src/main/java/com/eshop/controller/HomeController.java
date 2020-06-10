package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping ("/home")
    public String home(@RequestParam(value = "user", required = false, defaultValue = "Rosie") String user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }

}