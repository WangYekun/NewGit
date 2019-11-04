package com.javahly.spring01.test;

import com.javahly.spring01.config.AppConfig;
import com.javahly.spring01.service.BService;
import com.javahly.spring01.service.CService;
import com.javahly.spring01.service.DService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/29
 * @QQ :1136513099
 * @desc :多例解决循环依赖
 */
public class Test2 {
	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		CService cService = applicationContext.getBean("CService", CService.class);
		DService dService = applicationContext.getBean("DService", DService.class);
		cService.setdService(dService);
		dService.setcService(cService);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName+" ");
		}
	}
}
