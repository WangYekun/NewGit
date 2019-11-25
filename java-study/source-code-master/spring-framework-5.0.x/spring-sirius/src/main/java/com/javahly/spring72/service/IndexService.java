package com.javahly.spring72.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/17
 * @QQ :1136513099
 * @desc :
 */
@Component
public class IndexService {

	//@Autowired
	UserService userService;

	/*public IndexService(UserService userService) {
		//可以打印
		System.out.println(userService);
	}*/

	//@Autowired
	public void setUserService(UserService userService) {
		//不加@Autowired不能打印
		System.out.println("setter......"+userService);
		this.userService = userService;
	}

	public void query() {
		//System.out.println(userService);
		System.out.println("query......");
	}
}
