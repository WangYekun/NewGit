package com.personal.study;

import com.personal.study.dao.StudentMapper;
import com.personal.study.pojo.Student;
import com.personal.study.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
}
