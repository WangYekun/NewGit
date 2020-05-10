package study.pojo;

import lombok.Data;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
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