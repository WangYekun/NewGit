package com.rui;

import com.rui.dao.UserMapper;
import com.rui.pojo.User;
import com.rui.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        //第一步：获得SqlSession对象
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            //方式二：
            //List<User> userList = sqlSession.selectList("com.rui.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }

        }
        //关闭SqlSession
    }

    @Test
    public void getUserList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
