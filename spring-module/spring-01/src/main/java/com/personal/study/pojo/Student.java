package com.personal.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/10 20:00
 * @description 学生类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

/*    private String sex;

    private List<String> strings;

    private Map<String,String> maps;

    private Properties properties;

    private Set<String> set;*/

}
