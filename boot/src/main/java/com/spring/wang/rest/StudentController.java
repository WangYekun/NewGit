package com.spring.wang.rest;

import com.spring.wang.eneity.Student;
import com.spring.wang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:56
 * @description 学生控制层
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Student selectByPrimaryKey(@PathVariable Integer id) {
        return studentService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/deleteByPrimaryKey/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public int deleteByPrimaryKey(@PathVariable Integer id) {
        return studentService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKeySelective(Student student) {
        return studentService.updateByPrimaryKeySelective(student);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKey(Student student) {
        return studentService.updateByPrimaryKey(student);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insertSelective(Student student) {
        return studentService.insertSelective(student);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insert(Student student) {
        return studentService.insert(student);
    }

}
