package com.myapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;
import com.myapp.dao.ProviderRepository;
import com.myapp.model.Provider;
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
@RequestMapping("/provider")
public class ProviderRestController {

    @Autowired
    private ProviderRepository daoProvider;

    @GetMapping("")
    @JsonView(JsonPropertyView.Provider.class)
    @ResponseBody
    public ResponseEntity<List<Provider>> findAll() {
        System.out.println("GET: Provider");
        return new ResponseEntity<>(this.daoProvider.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional> findOne(@PathVariable Long id) {
        Optional<Provider> a = this.daoProvider.findById(id);
        if (this.daoProvider.findById(id).isPresent()) {
            System.out.println("GET: id " + id);
            return new ResponseEntity<Optional>(a, HttpStatus.OK);

        } else {
            System.out.println("GET: Failed using id " + id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Provider> add(@Valid @RequestBody Provider provider, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("POST: Has errors");
            throw new ProviderValidationException();
        }
        this.daoProvider.save(provider);
        System.out.println("POST: " + provider);
     return new ResponseEntity<>(provider, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Provider edit(@RequestBody Provider provider, @PathVariable String id) {
        this.daoProvider.save(provider);
        System.out.println("PUT: " + provider);
        return this.daoProvider.findById(provider.getId()).get();
    }

    @PatchMapping("/{id}")
    public Provider partialEdit(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
        Provider provider = this.daoProvider.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Provider.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, provider, value);
        });
        System.out.println("PATCH: " + provider);
        this.daoProvider.save(provider);
        return provider;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.daoProvider.deleteById(id);
        System.out.println("DELETE: Provider with id: " + id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Provider is not valid")
    public class ProviderValidationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}