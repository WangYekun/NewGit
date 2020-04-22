package com.spring.wang.eneity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:51
 * @description ${description}
 */

@Data
@ApiModel
@Api
public class Student {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "tid")
    private Integer tid;
}