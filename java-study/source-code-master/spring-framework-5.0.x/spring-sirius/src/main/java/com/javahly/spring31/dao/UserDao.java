package com.javahly.spring31.dao;


import com.javahly.spring31.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/4/13
 */
@Repository
public interface UserDao {

    public User selectUser(int id);

}
