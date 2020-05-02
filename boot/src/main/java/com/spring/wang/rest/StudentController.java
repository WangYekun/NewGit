package com.spring.wang.rest;

import com.spring.wang.eneity.Student;
import com.spring.wang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:56
 * @description 学生控制层
 */
@Api
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "创建新的用户", notes = "根据User对象创建用户")
    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Student selectByPrimaryKey(@PathVariable Integer id) {
        return studentService.selectByPrimaryKey(id);
    }

    @ApiOperation("删除接口")
    @RequestMapping(value = "/deleteByPrimaryKey/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public int deleteByPrimaryKey(@PathVariable Integer id) {
        return studentService.deleteByPrimaryKey(id);
    }

    @ApiOperation("更新id接口")
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKeySelective(Student student) {
        return studentService.updateByPrimaryKeySelective(student);
    }

    @ApiOperation("更新id接口")
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKey(Student student) {
        return studentService.updateByPrimaryKey(student);
    }

    @ApiOperation("新增接口")
    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insertSelective(Student student) {
        return studentService.insertSelective(student);
    }

    @ApiOperation("新增接口")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    public static void main(String[] args) { 
        Map<String, Object> objectObjectHashMap = new HashMap<>(16);
        objectObjectHashMap.put("1",1);
        objectObjectHashMap.put("2",1);
        objectObjectHashMap.put("3",1);
        objectObjectHashMap.put("4",1);
        objectObjectHashMap.put("5",1);
        objectObjectHashMap.put("6",1);
        System.out.println("objectObjectHashMap.toString() = " + objectObjectHashMap.toString());
    }

}
