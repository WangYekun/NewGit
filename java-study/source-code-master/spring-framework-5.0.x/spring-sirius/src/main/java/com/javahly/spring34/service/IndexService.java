package com.javahly.spring34.service;

import com.javahly.spring34.dao.IndexDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :
 */
@Service
public class IndexService implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private Map<String,IndexDao> map;

	public void query(String string){
		map.get("indexDao"+string+"Impl").query();
		/*IndexDao indexDao = (IndexDao) applicationContext.getBean("indexDao"+string+"Impl");
		indexDao.query();*/
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext......");
		this.applicationContext = applicationContext;
	}
}
