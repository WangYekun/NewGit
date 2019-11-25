package com.javahly.spring17.test;

import com.javahly.spring17.config.AppConfig;
import com.javahly.spring17.dao.IndexDao;
import com.javahly.spring17.impl.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
public class Test {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao indexDao = (IndexDao) applicationContext.getBean("indexDaoImpl");
		indexDao.query();
		System.out.println(".........................");
		indexDao.save("123456......");
		System.out.println(".........................");
		indexDao.delete();
	}
}
