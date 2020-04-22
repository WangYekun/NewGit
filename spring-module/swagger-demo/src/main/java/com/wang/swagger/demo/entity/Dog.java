package com.wang.swagger.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 18:10
 * @description 狗类
 */
@Data
@Component
public class Dog {

    @Value("旺财")
    private String name;

    @Value("男")
    private String sex;

}
