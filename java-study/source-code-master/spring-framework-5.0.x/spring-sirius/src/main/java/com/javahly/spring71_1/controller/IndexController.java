package com.javahly.spring71_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/20
 * @QQ :1136513099
 * @desc :
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("Controller......");
		return "123";
	}


	@ResponseBody
	@RequestMapping("/login")
	public Map<String,String> login(){
		Map<String,String> map = new HashMap<>();
		map.put("123","123");
		System.out.println("Login......");
		return map;
	}
}
