package com.javahly.spring35.impl;

import com.javahly.spring35.dao.IndexDao;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/17
 * @QQ :1136513099
 * @desc :
 */
@Component
public class IndexDaoImpl implements IndexDao {
	@Override
	public void query() {
		System.out.println("query......");
	}
}
