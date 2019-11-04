package com.javahly.spring27.config;

import com.javahly.spring27.dao.IndexDao1;
import com.javahly.spring27.dao.IndexDao2;
import com.javahly.spring27.imports.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/5
 * @QQ :1136513099
 * @desc :
 */
@Configuration
@ComponentScan("com.javahly.spring27")
//@Import(MyImportSelector.class)
public class AppConfig {

	@Bean
	public IndexDao1 indexDao1(){
		//根据构造方法实例对象
		//加了@Configuration 打印构造方法1遍，不加打印2遍，这个方法被改变了，不会返回new这个对象了
		//加了@Configuration产生代理对象，就不调用目标对象的方法了
		return new  IndexDao1();
	}

	@Bean
	public IndexDao2 indexDao2(){

		//手动调用，加了@Configuration 打印构造方法1遍，不加打印2遍
		indexDao1();
		return new IndexDao2();
	}
}
