package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/list")
    public String getProducts() {
        System.out.println("Listing all product");
        return "product";
    }
    @GetMapping ("/add/{idProduct}")
    public String addProduct(@PathVariable(value = "idProduct", required = false) int idProduct, Model model) {
        model.addAttribute("id", idProduct);
        System.out.println("Adding a product");
        return "product";
    }

    @GetMapping ("/edit/{idProduct}")
    public String editProduct(@PathVariable(value = "idProduct", required = false) int idProduct, Model model) {
        model.addAttribute("id", idProduct);
        System.out.println("Editing a product");
        return "product";
    }
    @GetMapping ("/delete/{idProduct}")
    public String deleteProduct(@PathVariable(value = "idProduct", required = false) int idProduct, Model model) {
        model.addAttribute("id", idProduct);
        System.out.println("Deleting a product");

        return "product";
    }


}
