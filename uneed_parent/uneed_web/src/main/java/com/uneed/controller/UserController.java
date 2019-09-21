package com.uneed.controller;

import com.uneed.entity.UserLogin;
import com.uneed.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/26 10:41
 */
@Controller
public class UserController {
    private static final String Hello = "hello";

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/test")
    public String test() {
        System.out.println("-------------------------------");
        return Hello;
    }

    @ResponseBody
    @RequestMapping("/getUserLogin")
    public List<UserLogin> getVideoInfo() {
        List<UserLogin> userLoginList = userLoginService.getVideoInfo();
        for (UserLogin userLogin : userLoginList) {
            System.out.println("========================================");

        }
        return userLoginList;
    }
}
