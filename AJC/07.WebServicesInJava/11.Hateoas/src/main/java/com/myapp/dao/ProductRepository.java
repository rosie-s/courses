package com.myapp.dao;

import com.myapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="products")
public interface ProductRepository extends JpaRepository<Product, Long> {
}