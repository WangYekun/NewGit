package com.wang.swagger.demo.rest;

import com.wang.swagger.demo.entity.Student;
import com.wang.swagger.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:04
 * @description 学生控制类
 */
@Api(value = "学生控制类", tags = "学生控制类")
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    private final StudentService studentService;

    public HelloController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试springboot项目是否启动成功")
    @ResponseBody
    public String hello() {
        return "springboot is started";
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "新增学生")
    @ResponseBody
    public int save(@RequestBody Student student) {
        return studentService.insert(student);
    }


    @GetMapping(value = "/getStudentById/{id}")
    @ApiOperation(value = "根据学生id查询学生")
    @ResponseBody
    public Student save(@PathVariable Integer id) {
        return studentService.selectByPrimaryKey(id);
    }

    @GetMapping(value = "/testThymeleaf")
    @ApiOperation(value = "测试模板")
    public String testThymeleaf(Model model) {
        model.addAttribute("message", "thymeleaf");
        return "test";
    }
}


