package com.spring.wang.rest;

import com.spring.wang.eneity.User;
import com.spring.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:56
 * @description 用户控制层
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public User selectByPrimaryKey(@PathVariable Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/deleteByPrimaryKey/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public int deleteByPrimaryKey(@PathVariable Integer id) {
        return userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKeySelective(User user) {
        return userService.updateByPrimaryKeySelective(user);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public int updateByPrimaryKey(User user) {
        return userService.updateByPrimaryKey(user);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insertSelective(User user) {
        return userService.insertSelective(user);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insert(User user) {
        return userService.insert(user);
    }

}
