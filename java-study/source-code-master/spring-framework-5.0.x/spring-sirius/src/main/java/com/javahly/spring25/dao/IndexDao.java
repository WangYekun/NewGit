package com.javahly.spring25.dao;
import com.javahly.spring25.app.MySelect;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/6/30
 * @QQ :1136513099
 * @desc :
 */

public interface IndexDao  {

	@MySelect("SELECT * FROM TEST(模拟MyBatis)")
	public void test();

}
