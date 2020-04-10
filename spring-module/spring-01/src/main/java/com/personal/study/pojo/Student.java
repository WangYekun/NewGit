package com.personal.study.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/10 20:00
 * @description 学生类
 */
@Data
public class Student {

    private Integer id;

    private String name;

    private String sex;

    private List<String> strings;

    private Map<String,String> maps;

    private Properties properties;

    private Set<String> set;



}
