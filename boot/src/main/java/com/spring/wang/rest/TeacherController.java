package com.spring.wang.rest;

import com.spring.wang.eneity.Teacher;
import com.spring.wang.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:56
 * @description 老师控制层
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Teacher selectByPrimaryKey(@PathVariable Integer id) {
        return teacherService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/deleteByPrimaryKey/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public int deleteByPrimaryKey(@PathVariable Integer id) {
        return teacherService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKeySelective(Teacher teacher) {
        return teacherService.updateByPrimaryKeySelective(teacher);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKey(Teacher teacher) {
        return teacherService.updateByPrimaryKey(teacher);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insertSelective(Teacher teacher) {
        return teacherService.insertSelective(teacher);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insert(Teacher teacher) {
        return teacherService.insert(teacher);
    }

}
