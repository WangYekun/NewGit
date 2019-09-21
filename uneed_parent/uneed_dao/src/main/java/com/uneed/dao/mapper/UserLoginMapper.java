package com.uneed.dao.mapper;

import com.uneed.entity.UserLogin;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/26 11:34
 */
public interface UserLoginMapper {

    /**
     * @return 查询所有用户
     */
    List<UserLogin> selectAll();
}
