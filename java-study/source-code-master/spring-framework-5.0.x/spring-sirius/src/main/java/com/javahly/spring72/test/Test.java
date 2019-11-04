package com.javahly.spring72.test;

import com.javahly.spring72.config.AppConfig;
import com.javahly.spring72.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/17
 * @QQ :1136513099
 * @desc :
 */
public class Test {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		/*IndexService indexService = (IndexService) applicationContext.getBean("indexService");
		indexService.query();*/

	}
}
