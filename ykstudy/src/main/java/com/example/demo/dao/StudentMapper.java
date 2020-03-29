package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/23 21:54
 * @description 学生接口层
 */
@Mapper
public interface StudentMapper {

    /**
     * 查询所有学生对象
     *
     * @return student对象
     */
    List<Student> findAllList();

    /**
     * 根据id查询学生
     *
     * @param id 学生id
     * @return 根据id查询所有学生对象
     */
    Student getStudentById(int id);

    /**
     * 根据id删除学生
     *
     * @param id 学生id
     * @return String 删除成功标志
     */
    int delete(int id);

    /**
     * 更新学生对象
     *
     * @param student 对象
     * @return String 更新成功标志
     */
    int update(Student student);

    /**
     * 新增学生对象
     *
     * @param student 对象
     * @return String 更新成功标志
     */
    int create(Student student);

}
