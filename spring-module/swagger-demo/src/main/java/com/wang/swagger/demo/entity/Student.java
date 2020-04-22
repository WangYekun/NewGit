package com.wang.swagger.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:51
 * @description 学生类
 */

@Data
@ApiModel(value = "学生类")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @ApiModelProperty(value = "学生id")
    private Integer id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "老师关联id")
    private Integer tid;

}