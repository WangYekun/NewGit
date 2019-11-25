package com.javahly.spring36.service;

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

	@Autowired
	UserService userService;

	/*public IndexService(UserService userService) {
	}*/

	public void query() {
		System.out.println("query......");
	}
}
