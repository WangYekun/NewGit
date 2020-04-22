package com.wang.swagger.demo.service;

import com.wang.swagger.demo.entity.Student;
import com.wang.swagger.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:48
 * @description ${学生业务层}
 */

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }


    public int insert(Student record) {
        return studentMapper.insert(record);
    }


    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }


    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

}
