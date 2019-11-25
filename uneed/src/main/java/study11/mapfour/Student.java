package study11.mapfour;

import lombok.Data;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/14 18:01
 * @description 学生类
 */
@Data
public class Student {

    private String id;
    private String name;

    public Student(String strName) {
        name = strName;
        id = "00";
    }

    @Override
    public String toString() {
        return id + " " + name + ", ";
    }

}