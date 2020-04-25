package com.wang.swagger.demo.practice;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/25 12:51
 * @description 字符串String练习
 */
public class StringPractice {

    public static void main(String[] args) {
        String s = "W";
        String s2 = "W324783243478,874837243248!";
        System.out.println("s.endsWith(\"!\") = " + "!".endsWith(s));
        String[] split = s2.split(",");
        for (String s1 : split) {
            System.out.println(s1);
        }
        System.out.println("\"S\".equals(s) = " + s2.equals(s));
        String s3 = "  1233456789777777777";
        // 去掉字符串前后(两端)空格
        System.out.println("s3.trim() = " + s3.trim());
        // 字符下标
        System.out.println("s1.indexOf(3) = " + s3.trim().indexOf("2"));
        // 判断是否存在字符
        System.out.println("s1.contains(\"2\") = " + s3.contains("2"));
        // 判断两字符串忽略大小写是否相等
        System.out.println("s2.equalsIgnoreCase(\"w\") = " + "w".equalsIgnoreCase(s));
        // 字符串长度
        System.out.println("s3.length() = " + s3.length());
        // 字符串拼接相当于SpringBuffer.append
        System.out.println("s3.concat(\"1\") = " + s3.concat("1"));
        // 替换字符串
        System.out.println("s3.replace(\"1\",\"2\") = " + s3.trim().replace("7", "2"));
        // 查找数组下标数据[4,7)有始无终
        System.out.println("s3.substring(4,7) = " + s3.trim().substring(4, 7));
    }
}
