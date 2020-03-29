package com.example.demo.service;

import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/23 22:02
 * @description 学生服务层
 */
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> findAllList() {
        return studentMapper.findAllList();
    }

    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    public int delete(int id) {
        return studentMapper.delete(id);
    }

    public int update(Student student) {
        return studentMapper.update(student);
    }

    public int create(Student student) {
        return studentMapper.create(student);
    }

}
