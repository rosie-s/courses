package com.app.dao;

import com.app.model.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<Long, Product> {
    public List<Product> getAllProducts(int product);
}
