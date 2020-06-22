package com.demomicro.categorieservice.controller;

import com.demomicro.categorieservice.model.Categorie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
public class CategorieController {

    @GetMapping("categories")
    public List<Categorie> getAll() {
        return Arrays.asList(
                new Categorie(1, "Categorie 1"),
                new Categorie(2, "Categorie 2"),
                new Categorie(3, "Categorie 3")
        );
    }

    @GetMapping("categories/{id}")
    public Categorie getAll(@PathVariable("id") int id) {

        return new Categorie(id, "Categorie "+id);
    }
}
