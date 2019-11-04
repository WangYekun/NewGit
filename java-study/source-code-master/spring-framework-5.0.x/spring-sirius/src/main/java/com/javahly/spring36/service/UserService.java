package com.javahly.spring36.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/18
 * @QQ :1136513099
 * @desc :
 */
@Component
public class UserService {

	@Autowired
	IndexService indexService;
}
