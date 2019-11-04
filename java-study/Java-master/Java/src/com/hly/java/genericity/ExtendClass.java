package com.hly.java.genericity;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class ExtendClass<T1> {

}

//继承ExtendClass类保留父类泛型
//若没指明，T1,T2,T3都会变成Object
//一般情况下都将父类的泛型类型保留
class SubClass<T1,T2,T3> extends ExtendClass<T1>{

}
