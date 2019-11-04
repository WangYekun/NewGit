package com.hly.java.tomcat;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/17
 */
public class App {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(9000);

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream ins = socket.getInputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = ins.read(buffer)) > 0) {
                    System.out.println(new String(buffer, 0, len));
                }

                OutputStream outs = socket.getOutputStream();
                ins = new FileInputStream("d:/input.txt");
                while ((len=ins.read(buffer))>0){
                    outs.write(new String(buffer,0,len).getBytes());
                }
                outs.flush();
                outs.close();
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
