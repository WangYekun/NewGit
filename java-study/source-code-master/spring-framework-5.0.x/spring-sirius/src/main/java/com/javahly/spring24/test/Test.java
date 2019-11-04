package com.javahly.spring24.test;


import com.javahly.spring24.config.AppConfig;
import com.javahly.spring24.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/30
 * @QQ :1136513099
 * @desc :
 */
public class Test {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		IndexDao indexDao = applicationContext.getBean(IndexDao.class);
		indexDao.test();
	}
}
