package com.example.demo.dao;

import org.springframework.data.mongodb.core.query.Update;

/**
 * @author lenovo
 */
public interface BaseDao<T> {

    boolean remove(String id);

    T get(String id);

    void insert(T t);

    boolean update(Update update, String id);

}
