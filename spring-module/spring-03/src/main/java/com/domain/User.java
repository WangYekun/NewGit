package com.domain;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/11 13:52
 * @description ${description}
 */
public class User {

    private Integer id;

    private String name;

    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}