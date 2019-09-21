package com.uneed.service;

import com.uneed.entity.UserLogin;

import java.util.List;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/26 11:54
 */
public interface UserLoginService {
    /**
     * @return 返回所有人信息
     */
    List<UserLogin> getVideoInfo();
}
