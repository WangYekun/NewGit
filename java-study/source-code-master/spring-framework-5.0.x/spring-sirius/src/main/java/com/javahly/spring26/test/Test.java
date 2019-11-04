package com.javahly.spring26.test;


import com.javahly.spring26.config.AppConfig;
import com.javahly.spring26.dao.IndexDao;
import com.javahly.spring26.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/4
 * @QQ :1136513099
 * @desc :
 */
public class Test {
	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//applicationContext.refresh();
		IndexDao indexDao = applicationContext.getBean(IndexDao.class);
		UserDao userDao = applicationContext.getBean(UserDao.class);
		userDao.test();
		indexDao.test();
	}
}
