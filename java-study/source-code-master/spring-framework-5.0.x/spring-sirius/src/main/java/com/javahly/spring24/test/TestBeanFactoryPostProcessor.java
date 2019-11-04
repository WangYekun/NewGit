package com.javahly.spring24.test;

import com.javahly.spring24.beanFactoryPostProcessor.MyBeanFactoryPostProcessor;
import com.javahly.spring24.config.AppConfig;
import com.javahly.spring24.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/2
 * @QQ :1136513099
 * @desc :
 */
public class TestBeanFactoryPostProcessor {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		//自定义的后置处理器
		//applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
		applicationContext.refresh();
		IndexDao indexDao1 = applicationContext.getBean(IndexDao.class);
		IndexDao indexDao2 = applicationContext.getBean(IndexDao.class);
		System.out.println(indexDao1);
		System.out.println(indexDao2);
	}
}
