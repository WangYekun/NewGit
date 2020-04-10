package com.personal.study.dao;

import com.personal.study.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/10 20:03
 * @description 学生持久层
 */
public interface StudentMapper {

    /**
     * 查询学生对象集合
     *
     * @return List集合
     */
    List<Student> getList();

    /**
     * 根据学生id查询精确查找学生对象
     *
     * @param id 学生id
     * @return 学生对象
     */
    Student getById(String id);

    /**
     * 添加学生对象
     *
     * @param map 学生对象
     * @return 学生对象
     */
    Student add(Map<String,Object> map);

    /**
     * 根据学生id删除学生对象
     *
     * @param id 学生id
     * @return 成功删除1, 失败0
     */
    int delete(String id);

    /**
     * 根据学生id更新学生对象
     *
     * @param student 学生对象
     * @return 成功删除1, 失败0
     */
    int update(Student student);

}
