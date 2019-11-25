package study11.mapfour;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/14 18:00
 * @description 测试map的crud
 */
public class MapFourTodo {
    public static void main(String[] args) {

        Map<String, Student> stu = Maps.newHashMap();

        //添加元素
        System.out.println("-----------//添加元素--------------");
        stu.put("0001", new Student("sunming1"));
        stu.put("0002", new Student("sunming2"));
        stu.put("0003", new Student("sunmnig3"));
        System.out.println(stu);

        //删除元素
        System.out.println("------------//删除元素-------------");
        stu.remove("0001");
        System.out.println(stu);

        //更新元素
        System.out.println("------------//更新元素-------------");
        stu.put("0002", new Student("sunmingUpdate"));
        System.out.println(stu);

        //查询元素
        System.out.println("----------- //查询元素--------------");
        System.out.println(stu.get("0003"));

        //获取所有的key和value
        System.out.println("----------//获取所有的key和value---------------");
        for (Map.Entry<String, Student> entry : stu.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        //获取所有的key
        System.out.println("-----------//获取所有的key--------------");
        Set<String> keys = stu.keySet();
        for (String key : keys) {
            System.out.println(key);
        }


        System.out.println("------------------//获取所有的value---------------");
        Collection<Student> values = stu.values();
        for (Student value : values) {
            System.out.println(value);
        }

    }
}
