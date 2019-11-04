package com.javahly.spring17.test;

import com.javahly.spring17.dao.IndexDao;
import sun.misc.ProxyGenerator;

import java.io.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
public class JdkProxyTest {
	public static void main(String[] args) throws IOException {
		Class<?>[] interfaces= new Class[]{IndexDao.class};
		byte bytes[]= ProxyGenerator.generateProxyClass("ProxyObjectTest",interfaces);
		File file = new File("d:/ProxyObjectTest.class");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytes);
		fos.flush();
		fos.close();


	}
}
