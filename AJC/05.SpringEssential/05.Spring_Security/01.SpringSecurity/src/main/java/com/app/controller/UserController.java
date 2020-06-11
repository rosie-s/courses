package com.app.controller;

import com.app.dao.UserRepository;
import com.app.model.User;
import com.app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.naming.Binding;
import javax.validation.Valid;
import java.sql.SQLOutput;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public String addLogin(Model model) {
        model.addAttribute("user", new User());
        return "users/add_user";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam("passwordConfirm") String passConfirm, Model model) {
        new UserValidator().validate(user, result);
        model.addAttribute("passwordConfirm", passConfirm);
        if (result.hasErrors()) {
            return "users/add_user";
        }
        System.out.println("User: " + user);
        userRepository.save(user);
        return "users/user_home";
    }
}
