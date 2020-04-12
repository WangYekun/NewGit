package com.spring.wang.service;

import com.spring.wang.eneity.Teacher;
import com.spring.wang.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Mark
 * @date  2020/4/12 1:51
 * @version 1.0
 * @description ${description}
 */

@Service
public class TeacherService{

    @Resource
    private TeacherMapper teacherMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    
    public Teacher selectByPrimaryKey(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }

}
