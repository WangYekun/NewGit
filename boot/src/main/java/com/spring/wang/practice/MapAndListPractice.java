package com.spring.wang.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/26 22:56
 * @description map和list操作
 */
public class MapAndListPractice {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>(16);
        map.put("1", new Date());
        System.out.println("map = " + map);

        List<String> objectLists = new ArrayList<>();
        objectLists.add("11");
        objectLists.add("12");
        objectLists.add("13");
        objectLists.add("14");
        objectLists.add("15");
        objectLists.add("16");
        System.out.println("objectLists.get(0) = " + objectLists.get(0));


        File descFile = new File("." + File.separator + "sql.sql");
        File sourceFile = new File("." + File.separator + "pom.xml");
        try (FileInputStream fis = new FileInputStream(descFile);
             FileOutputStream fos = new FileOutputStream(sourceFile)) {
            int len;
            byte[] buffer = new byte[4096];
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
