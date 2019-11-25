package com.javahly.spring22.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/29
 * @QQ :1136513099
 * @desc :
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

	private String dataSource;

	public void testBean(String dataSource){
		this.dataSource = dataSource;
		System.out.println("testDataSource");

	}
	@Override
	public Object getObject() throws Exception {
		TempDaoFactoryBean tempDaoFactoryBean = new TempDaoFactoryBean();
		tempDaoFactoryBean.setDataSource(dataSource);
		return tempDaoFactoryBean;
	}

	@Override
	public Class<?> getObjectType() {
		return TempDaoFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
