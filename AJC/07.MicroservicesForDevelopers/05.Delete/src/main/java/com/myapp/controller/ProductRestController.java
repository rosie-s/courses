package com.myapp.controller;

import com.myapp.dao.ProductRepository;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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
    public Product add(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            throw new ProductValidationException();
        }
        this.daoProduct.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product, @PathVariable int id) {
        this.daoProduct.save(product);
        System.out.println("Put " + product);
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
        this.daoProduct.save(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.daoProduct.deleteById(id);
        System.out.println("Deleted product with id: " + id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product is not valid")
    public class ProductValidationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}