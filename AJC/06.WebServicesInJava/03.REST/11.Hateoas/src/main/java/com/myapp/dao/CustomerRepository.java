package com.myapp.dao;

import com.myapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="customers")
public interface CustomerRepository extends JpaRepository<Customer, String> {
}