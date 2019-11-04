package com.hly.java.IO;

import java.io.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class ReaderAndWriter {

    public static void main(String[] args) {

        File file = new File("d:/java/ReaderAndWriter.text");
        if (file.exists()) {

            file.delete();
            System.out.println("已删除文件！");
        } else {
            try {
                file.createNewFile();
                FileWriter out = new FileWriter(file);
                String s = "I am CTO";
                out.write(s);
                out.close();
                System.out.println("文件已经创建！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
               FileReader in = new FileReader(file);
               char bytes[] = new char[1024];
               int len = in.read(bytes);
                System.out.println(new String(bytes,0,len));
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
