package com.rui;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rui.dao.UserMapper;
import rui.utils.MyBatisUtils;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(1);
        sqlSession.close();
    }
}
