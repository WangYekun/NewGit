package com.mapper;

import com.domain.User;

/**
 * @author Mark
 * @date  2020/4/11 13:52
 * @version 1.0
 * @description ${description}
 */

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}