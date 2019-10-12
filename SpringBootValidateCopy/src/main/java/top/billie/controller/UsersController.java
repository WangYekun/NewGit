package top.billie.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import top.billie.pojo.Users;

import javax.validation.Valid;


/**
 * @program: SpringBootValidate
 * @description:
 * @author: Billie
 * @create: 2019-06-27 17:07
 **/
@Controller
@Slf4j
public class UsersController {

    /**
     * @Description: 添加数据的控制器
     * @Param: [users]
     * @return: java.lang.String
     * @Author: Billie
     * @Date: 2019/6/27
     */
    @RequestMapping("/sign_up")
    public String showPage(@ModelAttribute("register") Users users) {
        return "register";
    }

    /**
     * @Description: 保存数据的控制器
     * @Param: [users, result]
     * @return: java.lang.String
     * @Author: Billie
     * @Date: 2019/6/27
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("register") @Valid Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        log.info("======== register users information ==========: {}", JSON.toJSONString(users));

        return "success";
    }

}
