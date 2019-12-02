package com.xiaoshuai.impl;

import com.xiaoshuai.HelloService;

/**
 * @author lenovo
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String speakHello(String name) {
        return "你好:" + name + "欢迎查阅小帅丶博客";
    }

}
