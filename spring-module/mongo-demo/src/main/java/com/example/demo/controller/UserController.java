package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.UtilConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lenovo
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户集合", tags = "学习mongo结合springboot")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 成功标识
     */
    @ApiOperation(value = "根据主键查询集合", notes = "根据主键查询集合")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable String id) {
        return userService.get(id);
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 成功标识
     */
    @ApiOperation(value = "根据主键删除集合", notes = "根据主键删除集合")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        return userService.remove(id) ? UtilConstants.SUCCESS : UtilConstants.FAIL;
    }

    /**
     * 修改数据
     *
     * @param user 集合user
     * @return 成功标识
     */
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody User user) {
        return userService.update(user) ? UtilConstants.SUCCESS : UtilConstants.FAIL;
    }

    /**
     * 新增数据
     *
     * @param user 集合user
     * @return 成功标识
     */
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String save(@RequestBody User user) {
        userService.insert(user);
        return UtilConstants.SUCCESS;
    }

}
