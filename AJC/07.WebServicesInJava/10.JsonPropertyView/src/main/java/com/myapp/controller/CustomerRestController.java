package com.myapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;
import com.myapp.dao.CustomerRepository;
import com.myapp.model.Customer;
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
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private CustomerRepository daoCustomer;

    @GetMapping("")
    @JsonView(JsonPropertyView.Customer.class)
    @ResponseBody
    public ResponseEntity<List<Customer>> findAll() {
        System.out.println("GET: Customer");
        return new ResponseEntity<>(this.daoCustomer.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional> findOne(@PathVariable String id) {
        Optional<Customer> a = this.daoCustomer.findById(id);
        if (this.daoCustomer.findById(id).isPresent()) {
            System.out.println("GET: id " + id);
            return new ResponseEntity<Optional>(a, HttpStatus.OK);

        } else {
            System.out.println("GET: Failed using id " + id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Customer> add(@Valid @RequestBody Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("POST: Has errors");
            throw new CustomerValidationException();
        }
        this.daoCustomer.save(customer);
        System.out.println("POST: " + customer);
     return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Customer edit(@RequestBody Customer customer, @PathVariable String id) {
        this.daoCustomer.save(customer);
        System.out.println("PUT: " + customer);
        return this.daoCustomer.findById(customer.getId()).get();
    }

    @PatchMapping("/{id}")
    public Customer partialEdit(@RequestBody Map<String, Object> fields, @PathVariable String id) {
        Customer customer = this.daoCustomer.findById(id).get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Customer.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, customer, value);
        });
        System.out.println("PATCH: " + customer);
        this.daoCustomer.save(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.daoCustomer.deleteById(id);
        System.out.println("DELETE: customer with id: " + id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Customer is not valid")
    public class CustomerValidationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}