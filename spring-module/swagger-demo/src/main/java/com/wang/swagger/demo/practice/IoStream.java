package com.wang.swagger.demo.practice;

import java.io.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/25 14:13
 * @description IO流练习
 */
public class IoStream {
    public static void main(String[] args) throws Exception {
        File file = new File("." + File.separator + "pom.xml");
        System.out.println("useStreamRead(file) = " + useStreamRead(file));
        System.out.println("=====================================");
        System.out.println("useErRead(file) = " + useErRead(file));
        System.out.println("=====================================");
        System.out.println("useStreamWrite(file) = " + useStreamWrite(file, "764237843248"));
        System.out.println("=====================================");
        System.out.println("useStreamWrite(file) = " + useErWrite(file, "764237843248"));
        Runtime.getRuntime().exec("notepad " + file.getCanonicalPath());
    }

    /**
     * 使用字节流写文件
     *
     * @param file 文件
     * @param s    写入信息
     * @return 字符
     * @throws IOException 文件找不到异常
     */
    private static String useStreamWrite(File file, String s) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = s.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        return s;
    }

    private static String useErWrite(File file, String s) throws IOException {
        FileWriter fileOutputStream = new FileWriter(file);
        fileOutputStream.write(s.toCharArray());
        fileOutputStream.close();
        return s;
    }

    /**
     * 使用字节流读取数据
     *
     * @param file 文件
     * @return 文件字符串
     * @throws IOException 异常
     */
    private static String useStreamRead(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        // 放数据
        byte[] bytes = new byte[(int) file.length()];
        // 读数据
        fileInputStream.read(bytes);
        // 关闭流
        fileInputStream.close();
        // 放在字符串中
        return new String(bytes);
    }

    /**
     * 使用字符流读取数据
     *
     * @param file 文件
     * @return 文件字符串
     * @throws IOException 异常
     */
    private static String useErRead(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        // 放数据
        char[] bytes = new char[(int) file.length()];
        // 读数据
        fileReader.read(bytes);
        // 关闭流
        fileReader.close();
        // 放在字节串中
        return new String(bytes);
    }

}
