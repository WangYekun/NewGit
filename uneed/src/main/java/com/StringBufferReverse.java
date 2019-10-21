package com;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/21 22:09
 * @description 字符串反转
 */
public class StringBufferReverse {
    public static void main(String[] args) {
        System.out.println("#################### string reverse #####################");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        stringBuilder.append("b");
        stringBuilder.append("c");
        stringBuilder.append("d");
        System.out.println("reverse before str ==========>" + stringBuilder);
        StringBuilder str = stringBuilder.reverse();
        System.out.println("reverse after str ===========>" + str);
    }
}






