package com.spring.wang.service;

import com.spring.wang.eneity.Student;
import com.spring.wang.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Mark
 * @date  2020/4/12 1:51
 * @version 1.0
 * @description ${description}
 */

@Service
public class StudentService{

    @Resource
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
