package study.dao;

import lombok.Data;

/**
 * @author Mark
 * @date  2020/4/15 0:44
 * @version 1.0
 * @description ${description}
 */

@Data
public class User {
    /**
    * 用户id
    */
    private Integer id;

    /**
    * 用户名称
    */
    private String name;

    /**
    * 用户密码
    */
    private String pwd;
}