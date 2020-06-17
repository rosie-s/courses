package com.myapp.controller;

import com.myapp.dao.ProductRepository;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository daoProduct;

    @GetMapping("")

    @ResponseBody
    public List<Product> findAll() {
        return this.daoProduct.findAll();
    }

    @PostMapping("")
    public Product add(@RequestBody Product product) {
        this.daoProduct.save(product);
        return product;
    }
}