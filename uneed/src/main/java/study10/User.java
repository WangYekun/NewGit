package study10;

import lombok.Data;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/29 14:47
 * @description 用户类(copy方法)
 */
@Data
public class User {

    private String name;
    private Integer age;
    private String dept;

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", dept='" + dept + '\'' + '}';
    }
}
