package study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.pojo.User;
import study.service.UserService;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/10 11:10
 * @description 用户控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param id 根据用户id获取用户数据
     * @return 获取用户信息
     */
    @GetMapping(value = "/get/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }
}
