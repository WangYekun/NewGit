package study.dao;

import lombok.Data;

/**
 * @author Mark
 * @date  2020/4/11 14:00
 * @version 1.0
 * @description ${description}
 */

@Data
public class User {
    private Integer id;

    private String name;

    private String pwd;
}