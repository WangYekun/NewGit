package com.wang.swagger.demo.mapper;

import com.wang.swagger.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:48
 * @description 学生持久层
 */
@Mapper
@Repository
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Map<String, Object> student);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getStudentList();

}