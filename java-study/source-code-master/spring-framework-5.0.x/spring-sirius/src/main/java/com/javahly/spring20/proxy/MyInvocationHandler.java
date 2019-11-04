package com.javahly.spring20.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/10
 * @QQ :1136513099
 * @desc :
 */
public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	/**
	 *
	 * 每次调用代理对象的方法,都会执行invoke
	 * @param proxy 代理对象
	 * @param method 目标方法,正在调用的方法
	 * @param args 目标方法的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("log......");
		return method.invoke(target,args);
	}
}
