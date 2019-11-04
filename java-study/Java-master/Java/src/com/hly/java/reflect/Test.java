package com.hly.java.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/9
 * @QQ :1136513099
 * @desc :
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //getAttributeValue();
        //setAttributeValue();
        //callMethod();
        //callMethodWithValues();
        setConstruct();
    }

    /**
     * Java 反射调用构造方法
     */
    private static void setConstruct() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz= Class.forName("com.hly.java.reflect.User");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        User user = (User) constructor.newInstance("haha");
        System.out.println(user.getUsername());
    }
    /**
     * 反射获取指定的属性的值
     */
    private static void getAttributeValue() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.hly.java.reflect.User");
        Field fieldUserName = clazz.getDeclaredField("username");
        Field fieldPassword = clazz.getDeclaredField("password");
        //如果是私有的变量，则必须设置，不然无法获取到值
        fieldUserName.setAccessible(true);
        fieldPassword.setAccessible(true);
        Object o = clazz.newInstance();
        System.out.println(fieldUserName.get(o));
        System.out.println(fieldPassword.get(o));
    }

    /**
     * 反射设置属性值
     *
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void setAttributeValue() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.hly.java.reflect.User");
        Field fieldUserName = clazz.getDeclaredField("username");
        fieldUserName.setAccessible(true);
        Object o = clazz.newInstance();
        fieldUserName.set(o, "sirius");
        System.out.println(fieldUserName.get(o));
    }

    /**
     * Java 反射调用方法
     */
    private static void callMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Class<?>更加规范，在某些类型转化时可以避免不必要的检查错误
        Class<?> clazz = Class.forName("com.hly.java.reflect.User");
        Object o = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("print");
        //私有方法要设置，不然无法调用
        method.setAccessible(true);
        method.invoke(o);
    }

    /**
     * Java 反射调用有参数的方法
     */
    private static void callMethodWithValues() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.hly.java.reflect.User");
        Object o = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("print", String.class, String.class);
        method.invoke(o, "sirisu", "124");
    }

    /**
     * 反射的实现方式
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    private static void reflectMethods() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //反射获取三种方法
        //1
        Class clazz1 = Class.forName("com.hly.java.reflect.User");
        //2
        Class clazz2 = User.class;
        //3
        User user = new User();
        Class clazz3 = user.getClass();

        //创建反射对象,调用无参构造方法
        Object newInstance1 = clazz1.newInstance();
        //设置私有属性的值
        Field fieldUsername = clazz1.getDeclaredField("username");
        //允许操作私有成员
        fieldUsername.setAccessible(true);
        //设置值
        fieldUsername.set(newInstance1, "123");
        //类型转换
        User user1 = (User) newInstance1;
        //输出
        System.out.println(user1.getUsername());

        //实例化有参构造方法
        Constructor<?> constructor = clazz3.getConstructor(String.class, String.class);
        User newInstance2 = (User) constructor.newInstance("123", "123");
        //System.out.println(newInstance2.getUsername());
    }
}
