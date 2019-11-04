package com.javahly.spring27.callback;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/6
 * @QQ :1136513099
 * @desc :
 */
public class MyMethodCallback implements MethodInterceptor {

	//方法拦截器

	/**
	 *
	 * @param o 代理对象
	 * @param method 目标对象的方法
	 * @param objects 参数
	 * @param methodProxy 代理对象方法
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("MyMethodCallback");
		return methodProxy.invokeSuper(o,objects);
	}
}
