package com.hly.java.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class ZipInput {

    public static void main(String[] args){
        ZipInputStream zin;

        try {
            zin = new ZipInputStream(new FileInputStream("java.zip"));
            //实例化对象，指明要进行解压的文件
            ZipEntry entry = zin.getNextEntry();
            System.out.println(entry.getName());
            //entry不为空，并不在同一目录下
            while (((entry = zin.getNextEntry())!=null)&&!entry.isDirectory()){
                File file = new File("d:\\"+entry.getName());//获取文件目录
                System.out.println(file);
                System.out.println(entry.getName());
                if(!file.exists()){//如果文件不存在
                    file.mkdirs();//创建文件所在的文件夹
                    file.createNewFile();//创建文件
                }
                zin.closeEntry();
                System.out.println(entry.getName()+"解压成功");
            }
            zin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
