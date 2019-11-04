package com.javahly.spring01.test;

import com.javahly.spring01.config.AppConfig;
import com.javahly.spring01.service.BService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/29
 * @QQ :1136513099
 * @desc :循环依赖
 */
public class Test {
	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		BService bService = applicationContext.getBean("BService",BService.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName+" ");
		}
	}
}
