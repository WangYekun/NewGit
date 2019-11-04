package com.javahly.spring71_1.web;

import com.javahly.spring71_1.config.AppConfig;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
public class SpringBootApplication {

	public static void run() throws ServletException {
		Tomcat tomcat  = new Tomcat();
		//addContext 不会加载实现了 WebApplicationInitializer
		tomcat.setPort(55555);
		//不会去找jsp，不会去执行OnStartUp
		tomcat.addContext("/","d:\\tomcat\\");
		System.out.println("=====init====");
		try {
			// Load Spring web application configuration
			AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
			ac.register(AppConfig.class);
			//加了refresh报错
			// Create and register the DispatcherServlet
			DispatcherServlet servlet = new DispatcherServlet(ac);
			Wrapper mvc = tomcat.addServlet("/","mvc",servlet);
			//web容器启动时执行Servlet的init
			mvc.setLoadOnStartup(1);
			mvc.addMapping("/");
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}

	}
}
