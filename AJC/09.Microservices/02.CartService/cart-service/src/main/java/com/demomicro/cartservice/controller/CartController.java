package com.demomicro.cartservice.controller;

import com.demomicro.cartservice.model.Categorie;
import com.demomicro.cartservice.model.Product;
import com.demomicro.cartservice.model.ProductItem;
import com.demomicro.cartservice.model.ProductList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CartController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("carts/{userid}")
    public List<ProductItem> getAll(@PathVariable("userid") int userid) {
        List<ProductItem> productItems = new ArrayList<>();

        restTemplate.getForObject("http://localhost:8082/products/user/"+userid, ProductList.class)
                .getProducts().stream().forEach( p -> {
                    ProductItem pi = new ProductItem();
                    pi.setId(p.getId());
                    pi.setProduct_name(p.getName());

                    Categorie c = restTemplate.getForObject("http://localhost:8081/categories/"+p.getCategorie_id(), Categorie.class);
                    pi.setCategory_name(c.getName());
                    productItems.add(pi);
                });

        return productItems;
    }


}
