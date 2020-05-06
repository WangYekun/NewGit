package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author lenovo
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    
}
