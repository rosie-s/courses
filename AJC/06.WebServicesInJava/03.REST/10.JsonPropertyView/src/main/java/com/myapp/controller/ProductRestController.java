package com.myapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;
import com.myapp.dao.ProductRepository;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository daoProduct;

    @GetMapping("")
    @JsonView(JsonPropertyView.All.class)
    @ResponseBody
    public ResponseEntity<List<Product>> findAll() {
        System.out.println("GET: Products");
        return new ResponseEntity<>(this.daoProduct.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional> findOne(@PathVariable Long id) {
        Optional<Product> a = this.daoProduct.findById(id);
        if (this.daoProduct.findById(id).isPresent()) {
            System.out.println("GET: id " + id);
            return new ResponseEntity<Optional>(a, HttpStatus.OK);

        } else {
            System.out.println("GET: Failed using id " + id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("POST: Has errors");
            throw new ProductValidationException();
        }
        this.daoProduct.save(product);
        System.out.println("POST: " + product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product, @PathVariable int id) {
        this.daoProduct.save(product);
        System.out.println("PUT: " + product);
        return this.daoProduct.findById(product.getId()).get();
    }

    @PatchMapping("/{id}")
    public Product partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
        Product product = this.daoProduct.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, product, value);
        });
        System.out.println("PATCH: " + product);
        this.daoProduct.save(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.daoProduct.deleteById(id);
        System.out.println("DELETE: product with id: " + id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product is not valid")
    public class ProductValidationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}