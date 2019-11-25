package com.javahly.spring27.test;


import com.javahly.spring27.callback.MyMethodCallback;
import com.javahly.spring27.config.AppConfig;
import com.javahly.spring27.dao.IndexDao1;
import com.javahly.spring27.dao.IndexDao2;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/5
 * @QQ :1136513099
 * @desc :
 */
public class Test {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig appConfig = (AppConfig) applicationContext.getBean("appConfig");

		/*IndexDao1 indexDao1 = (IndexDao1) applicationContext.getBean("indexDao1");
		indexDao1.test();*/
		/*IndexDao2 indexDao2 = (IndexDao2) applicationContext.getBean("indexDao2");
		indexDao2.test();*/
        //-----------------------------------
		/*Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(IndexDao2.class);
		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
		//添加方法的过滤器
		//对代理对象的所有方法进行拦截
		enhancer.setCallback(new MyMethodCallback());
		//代理对象继承了目标对象，是它的子类,cglib基于继承
		IndexDao2 indexDao2 = (IndexDao2) enhancer.create();
		indexDao2.test();*/

	}
}
