package com.hly.java.IO;

import java.io.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class InputAndOutPut {

    public static void main(String[] args){

        File file = new File("d:/java/file.text");
        if(file.exists()){
            System.out.println("文件名:"+file.getName());
            System.out.println("是否存在exist():"+file.exists());
            System.out.println("是否存在isFile():"+file.isFile());
            System.out.println();
            file.delete();
            System.out.println("已删除文件！");
        }
        else{
            try {
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                byte bytes[] = "I am CTO".getBytes();
                out.write(bytes);
                out.close();
                System.out.println("文件已经创建！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream in = new FileInputStream(file);
                byte[] bytes = new byte[2048];
                //从流中读入一定长度的字节
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
