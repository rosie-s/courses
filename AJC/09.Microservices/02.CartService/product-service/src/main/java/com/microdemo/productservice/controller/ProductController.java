package com.microdemo.productservice.controller;

import com.microdemo.productservice.model.Product;
import com.microdemo.productservice.model.ProductList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
@RestController
public class ProductController {


    @GetMapping("products/user/{userid}")
    public ProductList getAll(@PathVariable("userid") int userid) {
        return new ProductList(Arrays.asList(
                new Product(1, "Product 1" , 3),
                new Product(2, "Product 2", 1),
                new Product(3, "Product 3", 2)
        ));
    }

    @GetMapping("products/{id}")
    public Product getOne(@PathVariable("id") int id) {
        return new Product(id, "Product ", 2);

    }
}
