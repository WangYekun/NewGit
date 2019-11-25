package com.javahly.spring22.test;

import com.javahly.spring22.config.AppConfig;
import com.javahly.spring22.dao.DaoFactoryBean;
import com.javahly.spring22.dao.TempDaoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/30
 * @QQ :1136513099
 * @desc :模拟SqlSessionFactoryBean
 */
public class TestSqlSessionFactoryBean {

	public static void main(String[] args){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//一下类型转换异常
		//DaoFactoryBean daoFactoryBean = (DaoFactoryBean) applicationContext.getBean("daoFactoryBean");
		//此句可以执行
		DaoFactoryBean daoFactoryBean = (DaoFactoryBean) applicationContext.getBean("&daoFactoryBean");
		daoFactoryBean.testBean("dataSource");
		TempDaoFactoryBean tempDaoFactoryBean = (TempDaoFactoryBean) applicationContext.getBean("daoFactoryBean");
		System.out.println(tempDaoFactoryBean.getDataSource());
	}

}
