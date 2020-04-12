package com.spring.wang.service;

import com.spring.wang.eneity.User;
import com.spring.wang.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Mark
 * @date  2020/4/12 1:51
 * @version 1.0
 * @description ${description}
 */

@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
