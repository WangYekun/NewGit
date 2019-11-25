package com.javahly.spring34.annotation;

import com.javahly.spring34.imports.MyRedissonHttpSessionConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :使用了这个注解才会调用实现ImportAware接口的类，就能在那个类得到这个注解类各个注解的值，从而实现通过注解参数来对配置类设置功能
 */
@Retention(RetentionPolicy.RUNTIME)
@Import({MyRedissonHttpSessionConfiguration.class})
@EnableAspectJAutoProxy
public @interface EnableMyRedissonHttpSession {
	String value() default "hly";
}

//https://blog.csdn.net/zgyjk/article/details/80780165