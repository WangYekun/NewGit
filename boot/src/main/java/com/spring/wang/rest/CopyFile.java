package com.spring.wang.rest;

import java.io.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 21:36
 * @description 文件复制
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {

/*
        // 1.源文件 ==>读
        File source = new File("." + File.separator + "sql.sql");
        FileInputStream fileInputStream = new FileInputStream(source);

        // 2.目标文件 ==>写
        File target = new File("." + File.separator + "sqlCopy.sql");
        FileOutputStream fileOutputStream = new FileOutputStream(target);

        // 3.管子接取文件
        byte[] bytes = new byte[(int) source.length()];
        fileInputStream.read(bytes);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        fileInputStream.close();
        Runtime.getRuntime().exec("notepad " + target.getCanonicalPath());
*/


/*
        // 1.源文件 ==>读
        File source = new File("." + File.separator + "sql.sql");
        FileInputStream fio = new FileInputStream(source);
        BufferedInputStream bis = new BufferedInputStream(fio);

        // 2.目标文件 ==>写
        File target = new File("." + File.separator + "sqlCopy.sql");
        FileOutputStream fos = new FileOutputStream(target);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 3.缓冲流
        int end = -1;
        while ((end = bis.read()) != -1) {
            bos.write(end);
        }
        bos.close();
        bis.close();
        fos.close();
        fio.close();
        Runtime.getRuntime().exec("notepad " + target.getCanonicalPath());
*/

        // 1.目标文件 ==>读(字符流)
        File source = new File("." + File.separator + "sql.sql");
        FileReader fileReader = new FileReader(source);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 2.源文件 ==>写(字符流)
        File target = new File("." + File.separator + "copySql.sql");
        FileWriter fileWriter = new FileWriter(target);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        // 3.缓冲流
        int end = -1;
        while ((end = bufferedReader.read()) != -1) {
            bufferedWriter.write(end);
        }
        bufferedWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
        Runtime.getRuntime().exec("notepad " + target.getCanonicalPath());
    }
}
