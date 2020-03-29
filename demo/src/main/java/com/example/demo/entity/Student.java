package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/26 9:05
 * @description 学生实体类
 */
@Data
public class Student {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Integer isDeleted;

    private Date gtcTime;

    private Date gtuTime;

}
