package com.hly.java.exception;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/9
 */
public class MyExceptionTest {

    public  static int divide(int a, int b) throws MyException {

        if(b==0){
            throw new MyException("除数不能为0");
        }
        return a/b;

    }


    public static void main(String[] args) throws MyException {
      divide(10,0);
    }

}
