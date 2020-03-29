package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/19 17:42
 * @description 学生实体类
 */
@Table(name = "student")
@Data
public class Student {

    @ApiModelProperty(value = "自增主键id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    @Column(name = "age")
    private Integer age;

}
