package com.app.dao;

import com.app.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {

        List result = entityManager.createQuery("from Product").getResultList();
        System.out.println("There are " + result.size() + " products");
        return result;
    }

    @Override
    public Product findOne(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Product create(Product entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Product update(Product entity) {
        return entityManager.merge(entityManager.find(Product.class, entity.getId()));
    }

    @Override
    public void delete(Product entity) {
        entityManager.remove(entity);

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Product> getAllProducts(int product) {
        return null;
    }
}
