package com.hly.java.proxy.proxyOfDynamic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :
 */
public class Test {
    public static void main(String[] args){
        //创建目标对象
        IUserDao target = new UserDao();
        System.out.println("目标对象:"+target.getClass());
        //代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象:"+proxy.getClass());
        //执行代理方法
        proxy.save();
    }
}
