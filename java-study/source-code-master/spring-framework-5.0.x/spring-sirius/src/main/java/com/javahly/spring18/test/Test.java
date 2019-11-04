package com.javahly.spring18.test;

import com.javahly.spring18.config.AppConfig;
import com.javahly.spring18.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/10
 * @QQ :1136513099
 * @desc :
 */
public class Test {
	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao indexDao = (IndexDao) applicationContext.getBean("indexDaoImpl");
		indexDao.query();
		indexDao.save("Hello");
	}
}
