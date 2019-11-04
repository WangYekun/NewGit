package com.hly.java.genericity;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class OverClass<T> {//定义泛型类

    private T over;//定义泛型变量

    public T getOver() {
        return over;
    }

    public void setOver(T over) {
        this.over = over;
    }

    public static void main(String[] args){

        //声明该类对象根据不同需求指定<T>真正的类型
        OverClass<Boolean> overClass1 = new OverClass<Boolean>();
        OverClass<Float> overClass2 = new OverClass<Float>();
        overClass1.setOver(true);
        overClass2.setOver(1.2f);
        Boolean b = overClass1.getOver();//无需类型转换
        Float f = overClass2.getOver();//无需类型转换
        //实例化对象已指定为Float，赋值为Integer，编译器会报错。
        //Integer integer =overClass2.getOver();
        System.out.println(b);
        System.out.println(f);


    }
}
