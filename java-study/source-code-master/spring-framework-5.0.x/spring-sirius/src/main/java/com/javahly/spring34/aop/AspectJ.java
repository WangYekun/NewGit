package com.javahly.spring34.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :
 */
@Component
@Aspect
public class AspectJ {
	//execution 精确到方法以及参数
	@Pointcut("execution( * com.javahly.spring34.dao.*.*(..))")
	public void pointCut(){
	}

	@Before("pointCut()")
	public void before(){
		System.out.println("before......");
	}


}
