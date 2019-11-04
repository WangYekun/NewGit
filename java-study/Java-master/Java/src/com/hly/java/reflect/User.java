package com.hly.java.reflect;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/9
 * @QQ :1136513099
 * @desc :
 */
public class User {

    private String username = "hly";
    private String password = "123";

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void print(String username, String password) {
        System.out.println(username + "：" + password);
    }

    private void print() {
        System.out.println(this.username + "：" + this.password);
    }

}
