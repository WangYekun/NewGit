package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @author lenovo
 */
public interface UserService {

    User get(String id);

    boolean remove(String id);

    void insert(User user);

    boolean update(User user);

}
