package com.app.dao;

import com.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAllByUnitPriceBetween(double price1, double price2);
    public List<Product> findAllByDescriptionIsContaining(String name);
    public List<Product> findByDescriptionContaining(@Param("word") String word);
}
