package com.hly.java.collection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class MySet implements Comparable<Object> {
    int id;
    String password;

    public MySet(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(Object o) {
        MySet set = (MySet) o;
        int result = id > set.id ? 1 : (id == set.id ? 0 : -1);
        return result;
    }


    public static void main(String[] args) {
        MySet set1 = new MySet(1, "a");
        MySet set2 = new MySet(2, "b");
        MySet set3 = new MySet(3, "c");
        MySet set4 = new MySet(4, "d");
        TreeSet<MySet> tree = new TreeSet<>();
        tree.add(set1);
        tree.add(set2);
        tree.add(set3);
        tree.add(set4);
        Iterator<MySet> it = tree.iterator();//Set集合中所有对象的迭代器
        System.err.println("所有对象:");
        while (it.hasNext()){
            MySet set = (MySet)it.next();
            System.err.println("id:"+set.getId()+" "+"password:"+set.getPassword());
        }
        it = tree.headSet(set2).iterator();//截取排在set2之前的对象
        System.err.println("set2之前的对象:");
        while (it.hasNext()){
            MySet set = (MySet)it.next();
            System.err.println("id:"+set.getId()+" "+"password:"+set.getPassword());
        }

        it = tree.subSet(set2,set3).iterator();//截取排在set2和3之间的对象之间的对象
        System.err.println("set2和3之间的对象:");
        while (it.hasNext()){
            MySet set = (MySet)it.next();
            System.err.println("id:"+set.getId()+" "+"password:"+set.getPassword());
        }

    }
}
