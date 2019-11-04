package com.javahly.spring22.dao;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/29
 * @QQ :1136513099
 * @desc :
 */
public class TempDaoFactoryBean {

	private String dataSource;

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public void testBean(){
		System.out.println("TempDaoFactoryBean");
	}


}
