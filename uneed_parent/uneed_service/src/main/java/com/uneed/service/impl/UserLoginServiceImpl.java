package com.uneed.service.impl;

import com.uneed.dao.mapper.UserLoginMapper;
import com.uneed.entity.UserLogin;
import com.uneed.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/26 11:56
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> getVideoInfo() {
        return userLoginMapper.selectAll();
    }
}
