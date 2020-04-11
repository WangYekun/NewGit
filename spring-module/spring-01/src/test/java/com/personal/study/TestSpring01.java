package com.personal.study;

import com.personal.study.dao.StudentMapper;
import com.personal.study.pojo.Student;
import com.personal.study.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/10 18:12
 * @description 测试学习
 */
public class TestSpring01 {

    @Test
    public void test() {
        // 1、得到SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 2、获取mapper对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // 3、获取对象
        List<Student> students = mapper.getList();
        // 4、遍历对象
        for (Student student : students) {
            // 5、输出对象
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testGetById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // 数据库一一对应
        Student student = mapper.getById(1);
        System.out.println("student = " + student);
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", 21);
        map.put("name", "王");
        int addStudent = mapper.add(map);
        System.out.println("add = " + addStudent);
        // 删除增加修改要有事务的提交过程
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int update = mapper.update(new Student(1, "更新"));
        System.out.println("add = " + update);
        // 删除增加修改要有事务的提交过程
        if (update > 0) {
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int delete = mapper.delete(1);
        if (delete > 0) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
