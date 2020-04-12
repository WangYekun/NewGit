package com.spring.wang.rest;

import com.spring.wang.eneity.Bolg;
import com.spring.wang.service.BolgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 11:01
 * @description 博客控制层
 */
@RestController
@RequestMapping(value = "blog")
public class BlogController {

    @Autowired
    private BolgService bolgService;

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insertSelective(Bolg bolg) {
        return bolgService.insertSelective(bolg);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int insert(Bolg bolg) {
        return bolgService.insert(bolg);
    }

}
