package com.myapp.controller;

import com.myapp.dao.CategoryRepository;
import com.myapp.model.Category;
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
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    private CategoryRepository daoCategory;

    @GetMapping("")
    @ResponseBody
    public List<Category> findAll() {
        System.out.println("GET: Categories");
        return this.daoCategory.findAll();
    }

    @PostMapping("")
    public Category add(@Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("POST: Has errors");
            throw new CategoryValidationException();
        }
        this.daoCategory.save(category);
        System.out.println("POST: " + category);
        return category;
    }

    @PutMapping("/{id}")
    public Category edit(@RequestBody Category category, @PathVariable Long id) {
        this.daoCategory.save(category);
        System.out.println("PUT: " + category);
        return this.daoCategory.findById(category.getId()).get();
    }

    @PatchMapping("/{id}")
    public Category partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
        Category category = this.daoCategory.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Category.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, category, value);
        });
        System.out.println("PATCH: " + category);
        this.daoCategory.save(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.daoCategory.deleteById(id);
        System.out.println("DELETE: category with id: " + id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Category is not valid")
    public class CategoryValidationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}