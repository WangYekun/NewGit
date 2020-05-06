package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User get(String id) {
        return userDao.get(id);
    }

    @Override
    public boolean remove(String id) {
        return userDao.remove(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        Update update = new Update();
        update.set("userName", user.getUserName());
        update.set("passWd", user.getPassWord());
        return userDao.update(update, user.getId());
    }

}
