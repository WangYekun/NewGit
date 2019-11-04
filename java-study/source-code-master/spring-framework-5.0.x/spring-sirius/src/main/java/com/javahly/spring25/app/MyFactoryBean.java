package com.javahly.spring25.app;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Description;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/3
 * @QQ :1136513099
 * @desc : 模拟Mybatis
 */

public class MyFactoryBean implements FactoryBean ,InvocationHandler{

	Class clazz;

	public MyFactoryBean(Class clazz) {
		this.clazz =clazz;
	}

	@Override
	public Object getObject() throws Exception {
		Class[] classes = new Class[]{clazz};
		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(),classes,this);
		return proxy;
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy");
		Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName());
        MySelect mySelect = method1.getAnnotation(MySelect.class);
		System.out.println(mySelect.value());
		return null;
	}
}
