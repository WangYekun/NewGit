package com.kuang.pojo;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/8 22:09
 * @description 书籍实体类
 */
public class Address {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                '}';
    }
}