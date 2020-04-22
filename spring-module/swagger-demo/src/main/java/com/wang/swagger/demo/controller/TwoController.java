package com.wang.swagger.demo.controller;

import com.wang.swagger.demo.entity.Student;
import com.wang.swagger.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:04
 * @description 学生控制类
 */
@Api(value = "学生控制类", tags = "学生控制类")
@RestController
@RequestMapping(value = "/two")
public class TwoController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试springboot项目是否启动成功")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "新增学生")
    public int save(@RequestBody Student student) {
        return studentService.insert(student);
    }


    @GetMapping(value = "/getStudentById/{id}")
    @ApiOperation(value = "根据学生id查询学生")
    public Student save(@PathVariable Integer id) {
        return studentService.selectByPrimaryKey(id);
    }

}


