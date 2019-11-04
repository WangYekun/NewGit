package com.javahly.spring18.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

	//within 只精确到类，不能使用在接口上
	@Pointcut("within(com.javahly.spring18.impl.*)")
	public void pointCutWithin() {
	}

	//@Before("pointCutWithin()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before ......");
		//System.out.println(joinPoint.getThis());
		//System.out.println(joinPoint.getTarget());
	}

	//@After("pointCutWithin()")
	public void after() {
		System.out.println("after ......");
	}

	//环绕通知改变参数
	//@Around("pointCutExecution()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around ......");
		Object args[] = pjp.getArgs();
		if(args!=null&&args.length>0){
			for (int i = 0; i <args.length ; i++) {
				args[i]+=" World";
			}
		}
		//处理目标方法
		pjp.proceed(args);
		System.out.println("around ......");
	}
}
