package com.hly.java.genericity;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/7
 */
public class ArrayClass<T> {
    private T[] array;
    //private T[] array = new T[10];不能用泛型来建立数组实例

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public static void main(String[] args){
       ArrayClass<String> a = new ArrayClass<String>();
       String [] array ={"a","b","c","d"};
       a.setArray(array);
       for(int i=0;i<a.getArray().length;i++){
           System.out.println(a.getArray()[i]);
       }
    }
}
