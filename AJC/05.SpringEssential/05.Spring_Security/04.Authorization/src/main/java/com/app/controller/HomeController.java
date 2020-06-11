package com.app.controller;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(value = "user", required = false, defaultValue = "Rosie") String user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }

}