package com.hly.java.proxy.proxyOfStatic.dao;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
//目标对象
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void find() {
        System.out.println("查询");
    }
}
