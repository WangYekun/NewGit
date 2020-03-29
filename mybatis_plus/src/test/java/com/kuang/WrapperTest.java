package com.kuang;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        /*    SELECT
        id,
        name,
        age,
        email,
        version,
        deleted,
        create_time,
        update_time
    FROM
        user
    WHERE
        deleted=0
        AND name IS NOT NULL
        AND email IS NOT NULL
        AND age >= 2*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 2);
        userMapper.selectList(wrapper).forEach(System.out::println); // 和我们刚才学习的map对比一下
    }

    @Test
    void test2() {
        // 查询名字狂神说
        /*    SELECT
        id,
        name,
        age,
        email,
        version,
        deleted,
        create_time,
        update_time
    FROM
        user
    WHERE
        deleted=0
        AND name = '狂神说'
        * */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "狂神说");
        User user = userMapper.selectOne(wrapper); // 查询一个数据，出现多个结果使用List 或者 Map
        System.out.println(user);
    }

    @Test
    void test3() {
        // 查询年龄在 20 ~ 30 岁之间的用户
        /*
            SELECT
        COUNT(1)
    FROM
        user
    WHERE
        deleted=0
        AND age BETWEEN 20 AND 30
        * */
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30); // 区间
        Integer count = userMapper.selectCount(wrapper);// 查询结果数
        System.out.println(count);
    }

    // 模糊查询
    @Test
    void test4() {
        // 查询年龄在 20 ~ 30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 左和右  t%
        wrapper
                .notLike("name", "e")
                .likeRight("email", "t");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 模糊查询
    @Test
    void test5() {

        /*    SELECT
        id,
        name,
        age,
        email,
        version,
        deleted,
        create_time,
        update_time
    FROM
        user
    WHERE
        deleted=0
        AND id IN (
            select
                id
            from
                user
            where
                id<3
        )*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id<3");

        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    //测试六
    /*    SELECT
        id,
        name,
        age,
        email,
        version,
        deleted,
        create_time,
        update_time
    FROM
        user
    WHERE
        deleted=0
    ORDER BY
        id ASC*/
    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过id进行排序
        wrapper.orderByAsc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

}
