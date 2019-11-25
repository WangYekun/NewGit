package com.javahly.spring17.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
@Aspect
@Component
public class AspectJ {

	//execution 精确到方法以及参数
	@Pointcut("execution(* *com.javahly.spring17.dao.IndexDao.query(..))")
	public void pointCutExecution(){
	}
	//within 只精确到类，不能使用在接口上
	@Pointcut("within(com.javahly.spring17.impl.*)")
	public void pointCutWithin(){
	}

	//根据传入的参数类型匹配，与方法名和包名无关
	@Pointcut("args(String)")
	public void pointCutArgs(){
	}

	//切入加了相关注解的类或者方法，只能用在类上，不能用在接口上
	//@Pointcut("@annotation(com.javahly.spring17.annotation.EnableMyRedissonHttpSession)")
	@Pointcut("@within(com.javahly.spring17.annotation.Hly)")
	public void pointCutAnnotation(){
	}

	//this 代理对象的类型为该类型才切入
	//target 目标对象的类型为该类型才切入
	@Pointcut("this(com.javahly.spring17.impl.IndexDaoImpl)")
	//@Pointcut("target(com.javahly.spring17.impl.IndexDaoImpl)")
	public void pointCutThis(){
	}

	@Before("pointCutExecution()")
	public void before(){
		System.out.println("before ......");
	}

	@After("pointCutWithin()")
	public void after(){
		System.out.println("after ......");
	}

	@Before("pointCutArgs()&&!pointCutExecution()")
	public void beforeArgs(){
		System.out.println("before(Args) ......");
	}

	@Before("pointCutAnnotation()")
	public void beforeAnnotation(){
		System.out.println("before(Annotation) ......");
	}

	@Before("pointCutThis()")
	public void beforeThis(){
		System.out.println("before(This) ......");
	}

}
