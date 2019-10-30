package com.hly.java.packagingType;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/11
 */
public class MyBoolean {
    public static void main(String[] args){
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("ok");
        System.out.println("b1:"+b1.booleanValue());
        System.out.println("b2:"+b2.booleanValue());

        //将字符串参数解析为boolean值。
        System.out.println("b3:"+Boolean.valueOf("true"));
        //返回用指定字符串表示值的boolean值。
        System.out.println("b4:"+Boolean.parseBoolean("true"));

    }
}
