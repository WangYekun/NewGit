package com.javahly.spring71_1.web;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/20
 * @QQ :1136513099
 * @desc :
 */
public class SpringApplication {

	public static void run() throws ServletException {
		Tomcat tomcat  = new Tomcat();
		//addWebapp 声明为Web应用，会加载 WebApplicationInitializer
		tomcat.addWebapp("/","d:\\tomcat\\");
		tomcat.setPort(55555);
		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}

	}
}
