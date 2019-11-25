package com.javahly.spring31.test;

import com.javahly.spring31.config.AppConfig;
import com.javahly.spring31.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :
 */
public class TestMyBatis {

	public static void main(String[] args) throws IOException {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		UserDao userDao = applicationContext.getBean(UserDao.class);
		System.err.println(userDao.selectUser(1));
		System.err.println(userDao.selectUser(1));

	}
}
