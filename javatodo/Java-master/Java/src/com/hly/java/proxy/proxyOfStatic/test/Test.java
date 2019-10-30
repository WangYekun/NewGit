package com.hly.java.proxy.proxyOfStatic.test;

import com.hly.java.proxy.proxyOfStatic.dao.IUserDao;
import com.hly.java.proxy.proxyOfStatic.dao.UserDaoProxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :静态代理测试
 */
public class Test {

    public static void main(String[] args){
        IUserDao proxy = new UserDaoProxy();
        proxy.save();

    }
}
