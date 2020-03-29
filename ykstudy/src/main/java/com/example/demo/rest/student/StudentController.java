package com.example.demo.rest.student;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/23 22:09
 * @description 学生控制层
 */
@Api(tags = "学生接口")
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    /**
     * 构造器注入更适合强制性的注入旨在不变性
     */
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "查询全部学生接口", notes = "查询全部学生接口")
    @RequestMapping(value = "/findAllList", method = RequestMethod.GET)
    public List<Student> findAllList() {
        return studentService.findAllList();
    }

    @ApiOperation(value = "根据学生ID查询接口", notes = "根据学生ID查询接口")
    @RequestMapping(value = "/getStudentById/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @ApiOperation(value = "根据学生ID删除接口", notes = "根据学生ID删除接口")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        return studentService.delete(id);
    }

    @ApiOperation(value = "根据学生ID更新接口", notes = "根据学生ID更新接口")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public int update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @ApiOperation(value = "创建学生接口", notes = "创建学生接口")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody Student student) {
        return studentService.create(student);
    }

}
