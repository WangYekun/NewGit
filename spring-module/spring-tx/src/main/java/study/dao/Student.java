package study.dao;

import lombok.Data;

/**
 * @author Mark
 * @date  2020/4/15 0:44
 * @version 1.0
 * @description ${description}
 */

@Data
public class Student {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 学生姓名
    */
    private String name;

    /**
    * 老师id
    */
    private Integer tid;
}