package com.javahly.spring16.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc : 生命周期初始化，销毁回调
 */
@Component

public class IndexDaoImpl implements IndexDao,InitializingBean,DisposableBean {

	public IndexDaoImpl() {
		System.out.println("构造方法.....");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("销毁");
	}
}
