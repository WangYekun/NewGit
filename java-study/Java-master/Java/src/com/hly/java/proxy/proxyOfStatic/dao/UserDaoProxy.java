package com.hly.java.proxy.proxyOfStatic.dao;

import java.util.Iterator;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :静态代理(聚合，接口形式)还有一种是继承，代理对象继承目标对象
 */
public class UserDaoProxy implements IUserDao {

    /**
     * 静态代理(聚合) 特点
     * 1.目标对象必须实现接口
     * 2.代理对象要实现与目标对象一样的接口
     */
    //代理对象，需要维护一个目标对象
    private IUserDao target = new UserDao();

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");

    }

    @Override
    public void find() {
        target.find();

    }
}
