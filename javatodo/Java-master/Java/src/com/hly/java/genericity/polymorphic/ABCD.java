package com.hly.java.genericity.polymorphic;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class ABCD {
    /**
     * java三大特性封装，继承，多态之：
     * 多态
     * @param args
     */
    public static void main(String[] args) {
        //downcasting();
        test();
    }


    /**
     * B继承A，向上转型
     */
    public static void upcasting() {
        B b = new B();
        A a = b;
    }
    /**
     * B继承A，向下转型
     */
    public static void downcasting() {
        A a = new A();
        //编译正常，运行报错
        //编译只检查类型之间是否存在继承关系，有则通过
        //运行检查真实类型，是则通过，否则抛异常
        B b = (B) a;

        //编译正常，运行成功
        //内存中本质是B类型，赋值给A,只有A中的方法，能力弱化
        A a2 = new B();
        //a2本质类型是B类型，强制转换成功
        B b1 = (B) a2;

        //总结：父类强制转化为子类，只有引用类型真正的身份为子类，才会强制转换成功。
    }

    public static void test() {

        A a1 = new A();
        A a2 = new B();//超类对象只会重写子类对象的方法，对于子类对象新方法不会定义
        B b = new B();//B会添加超类A存在但B不存在的方法
        C c = new C();
        D d = new D();

        System.out.println(a1.show(b));//结果：A - A，A<-B<-D ；结果：show(A obj)；不是：show(D obj)
        System.out.println(a1.show(c));//结果：A - A，A<-B<-C ;结果：show(A obj)
        System.out.println(a1.show(d));//结果：A - D，调用A类中的show(D obj)
        //结论：当对象方法不存在时，调用映射父类或者父类的父类方法

        System.out.println(a2.show(b));//结果：B - A，调用了B中的show(A obj)，A类重写了B中的show(A obj)
        System.out.println(a2.show(c));//结果：B - A，调用了B中的show(A obj)，A类重写了B中的show(A obj)
        System.out.println(a2.show(d));//结果：A - D，调用了A中的show(D obj)，B中没有show(D obj)
        //结论：超类对象只会重写子类对象的方法，对于子类对象新方法不会定义
        System.out.println(b.show(b));//结果：B - B，调用B类中方法：show(B obj)
        System.out.println(b.show(c));//结果：B - B，A,B中都没有show(C obj)，找到父类B,调用B类中方法：show(B obj)
        System.out.println(b.show(d));//结果：A - D,调用A中的show(D obj)
        //结论：B会添加超类A存在但B不存在的方法
        //对于一个对象引用变量引用子类对象，
        // 他会加载对象父类的方法，并重写对象中与子类相同的方法，
        // 而当new一个相同对象时，他只会加载对象中不存在且父类中存在的方法，并不会覆盖对象中原有的方法
        //当对象中方法不存在时，它会寻找入参的（super）父类及父类的父类匹配（所有继承关系的类），都不存在，编译就会报错。
        //https://blog.csdn.net/sunshine_fan/article/details/78707648

    }
}
