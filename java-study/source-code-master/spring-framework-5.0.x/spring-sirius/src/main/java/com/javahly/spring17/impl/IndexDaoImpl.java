package com.javahly.spring17.impl;

import com.javahly.spring17.annotation.Hly;
import com.javahly.spring17.dao.IndexDao;
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
@Hly
@Component
public class IndexDaoImpl implements IndexDao {

	@Override
	public void query() {
		System.out.println("query......");
	}

	@Override
	public void save(String id) {
		System.out.println("save"+id);
	}


	@Override
	public void delete() {
		System.out.println("delete......");
	}
}
