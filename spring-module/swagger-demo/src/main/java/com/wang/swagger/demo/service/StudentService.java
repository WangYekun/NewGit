package com.wang.swagger.demo.service;

import com.wang.swagger.demo.entity.Student;
import com.wang.swagger.demo.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:48
 * @description ${学生业务层}
 */
@Service
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    /**
     * transaction is use public method and use begin to end.
     *
     * @param student Student entity for map to use how to do it.
     * @return insert success flag(int)
     */
    public int insert(Map<String, Object> student) {
        log.debug("#### insert to student #####,[{}]", student);
        return studentMapper.insert(student);
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

    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

}
