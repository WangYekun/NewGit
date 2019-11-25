package com.javahly.spring34.impl;

import com.javahly.spring34.dao.IndexDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :
 */
@Component

public class IndexDaoAImpl implements IndexDao {
	@Override
	public void query() {
		System.out.println("query A......");
	}
}
