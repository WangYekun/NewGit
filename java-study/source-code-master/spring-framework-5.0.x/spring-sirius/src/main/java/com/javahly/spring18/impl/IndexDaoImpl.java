package com.javahly.spring18.impl;


import com.javahly.spring18.dao.IndexDao;
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

@Component
public class IndexDaoImpl implements IndexDao {
	public IndexDaoImpl() {
		System.out.println("aaa");
	}

	@Override
	public void query() {
		System.out.println("query......");
	}

	@Override
	public void save(String string) {
		System.out.println("save："+string);
	}


	@Override
	public void delete() {
		System.out.println("delete......");
	}
}
