package com.javahly.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/18
 * @QQ :1136513099
 * @desc :
 */
@Service
@Scope("prototype")
public class AService {

	@Autowired
	BService bService;
}
