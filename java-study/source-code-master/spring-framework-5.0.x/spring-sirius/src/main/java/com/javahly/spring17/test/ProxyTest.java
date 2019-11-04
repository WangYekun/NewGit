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
public class ProxyTest {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//proxyTargetClass = false 会报错，没有找到可用的 IndexDao的类型
		//IndexDao indexDao = applicationContext.getBean(IndexDaoImpl.class);
		IndexDao indexDao = (IndexDao) applicationContext.getBean("indexDaoImpl");
		//proxyTargetClass = false时，默认为JDK动态代理，为false,true,true
		System.out.println(indexDao instanceof IndexDaoImpl);//false,不等于目标对象
		System.out.println(indexDao instanceof IndexDao);//true，实现了它
		System.out.println(indexDao instanceof Proxy);//true，继承了它
	}
}
