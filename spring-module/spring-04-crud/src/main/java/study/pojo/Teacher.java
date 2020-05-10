package study.pojo;

import lombok.Data;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
 * @description ${description}
 */

@Data
public class Teacher {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 老师名字
     */
    private String name;
}