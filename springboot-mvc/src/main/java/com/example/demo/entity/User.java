package com.example.demo.entity;

import lombok.Data;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/25 23:12
 */
@Data
public class User {
    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
