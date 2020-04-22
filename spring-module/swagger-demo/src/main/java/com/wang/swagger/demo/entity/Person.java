package com.wang.swagger.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 18:10
 * @description 个人类
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    private String name;

    private String sex;

    private Integer age;

    private Date birth;

    private List<Object> lists;

    private Map<String, Object> map;

    private Dog dog;

    private Boolean happy;

}
