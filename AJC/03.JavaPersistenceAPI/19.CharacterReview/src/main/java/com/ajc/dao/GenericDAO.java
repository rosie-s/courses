package com.ajc.dao;

import java.util.List;

public abstract interface GenericDAO<T, K> {
    public List<T> findAll();
    public T findById(K key) ;
    public void create(T entity);
    public void update(T entity);
    public void delete(T entity);
    public void deleteByKey(K key);
}
