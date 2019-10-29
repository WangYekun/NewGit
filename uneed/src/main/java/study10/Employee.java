package study10;

import lombok.Data;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/29 14:48
 * @description 职工类(用于copy)
 */
@Data
public class Employee {
    private String name;
    private Integer age;
    private String dept;

    public Employee(String name, Integer age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }


    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", dept='" + dept + '\'' + '}';
    }
}
