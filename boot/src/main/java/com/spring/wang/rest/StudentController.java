package com.spring.wang.rest;

import com.spring.wang.eneity.Student;
import com.spring.wang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // @ApiImplicitParams 用来定义接口参数，并指定描述的，
    // @ApiResponses  用来定义添加额外的响应值，与配置类中的全局响应功能一致。
    @ApiOperation(value="创建新的用户", notes="根据User对象创建用户")
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
    public int insert(Student student) {
        return studentService.insert(student);
    }

}
