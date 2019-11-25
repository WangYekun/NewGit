package com.hly.java.IO;

import java.io.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class BufferReaderAndWriter {

    public static void main(String[] args){

        File file = new File("d:/java/BufferReaderAndWriter.txt");
        String str[] = {"I","am","CTO"};
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(String s:str){
                bw.write(s);
                bw.newLine();
            }
            //bw先关闭
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            int i =0;
            while((s = br.readLine())!=null){
                i++;
                System.out.println("第"+i+"行："+s);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
