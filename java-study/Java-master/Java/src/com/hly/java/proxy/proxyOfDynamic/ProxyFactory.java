package com.hly.java.proxy.proxyOfDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/9
 * @QQ :1136513099
 * @desc :动态代理
 */
//代理工厂，给多个目标对象生成代理对象
public class ProxyFactory {

    //接收一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回目标对象(target)代理后的对象(proxy)
    public Object getProxyInstance() {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象使用的类加载器
                target.getClass().getInterfaces(),//目标对象实现的所有接口
                new InvocationHandler() {//执行代理对象方法时触发
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //获取当前执行的方法的方法名
                        String methodName = method.getName();
                        //方法返回值
                        Object result = null;
                        if ("find".equals(methodName)) {
                            result = method.invoke(target, args);
                        } else {
                            System.out.println("开启事务");
                            result = method.invoke(target, args);
                            System.out.println("提交事务");
                        }
                        return result;
                    }
                }
        );
        return proxy;
    }


}
