package com.javahly.spring20.test;


import com.javahly.spring20.dao.IndexDao;
import com.javahly.spring20.impl.IndexDaoImpl;
import com.javahly.spring20.proxy.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/10
 * @QQ :1136513099
 * @desc :
 */
public class Test {

	public static void main(String[] args){
		IndexDao indexDao = (IndexDao) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{IndexDao.class},
		new MyInvocationHandler(new IndexDaoImpl()));
		indexDao.query();
	}
}
