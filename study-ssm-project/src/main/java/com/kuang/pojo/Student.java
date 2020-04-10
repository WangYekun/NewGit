package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/8 22:09
 * @description 书籍实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private String sex;
    private Address address;
    private List<String> mouse;
    private Map<String,String> hubby;
    private Properties properties;
    private String[] arrays;
}