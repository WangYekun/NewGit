package study11.mapfour;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/14 18:01
 * @description 学生类
 */
public class Student {

    private String id;
    private String name;

    public Student(String strName) {
        name = strName;
        id = "00";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name + ", ";
    }

}