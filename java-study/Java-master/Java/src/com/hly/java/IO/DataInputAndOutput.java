package com.hly.java.IO;

import java.io.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class DataInputAndOutput {

    public static void main(String[] args){

        try {
            FileOutputStream fos = new FileOutputStream("d:/java/DataInputAndOutput.txt");
            DataOutputStream ds = new DataOutputStream(fos);
            ds.writeUTF("writeUTF");
            ds.writeChars("writeChars");
            ds.writeBytes("writeBytes");
            ds.close();
            FileInputStream fis = new FileInputStream("d:/java/DataInputAndOutput.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
