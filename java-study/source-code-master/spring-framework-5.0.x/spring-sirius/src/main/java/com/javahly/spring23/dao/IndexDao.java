package com.javahly.spring23.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/30
 * @QQ :1136513099
 * @desc :
 */
@Component
public class IndexDao implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public IndexDao() {
		System.out.println("构造方法");
	}
	@PostConstruct
	public void init(){
		System.out.println("初始化");
		System.out.println(applicationContext);
	}

	public void test(){
		System.out.println("test");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
