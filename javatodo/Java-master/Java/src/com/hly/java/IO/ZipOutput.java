package com.hly.java.IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/4
 */
public class ZipOutput {

    public static void main(String[] args) throws IOException {

        ZipOutput zipOutput = new ZipOutput();
        zipOutput.zip("d:/java.zip",new File("d:/java"));
        System.out.println("压缩完成");
        System.out.println("");
    }

    private void zip(String zipFileName, File inputFile) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out,inputFile,"");
        System.out.println("压缩中...");
        out.close();
    }

    private void zip(ZipOutputStream out,File f,String base) throws IOException {

        if(f.isDirectory()){//测试此抽象路径名表示的文件是否是一个目录
            File [] fl = f.listFiles();//获取路径数组
            out.putNextEntry(new ZipEntry(base+"/"));//写入此目录的entry
            base = base.length()==0?"":base+"/";//判断参数是否为空
            for(int i=0;i<fl.length;i++){//循环遍历数组中的文件
                zip(out,fl[i],base+fl[i]);
            }
        }else{//创建新的进入点
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            System.out.println(base);
            while ((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
        }
    }


}
