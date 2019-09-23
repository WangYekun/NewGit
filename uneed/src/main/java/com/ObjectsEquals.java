package com;

import java.util.Objects;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/9/23 15:58
 */
public class ObjectsEquals {
    public static void main(String[] args) {
        // 避免被零除
        Double total = 100D;
        Double cost = 0D;
        Double avg = 0D;
        if (!Objects.equals(cost, 0)) {
            avg = total / cost;
        }

        // 切记，比较的需要时相同的类
        if (!Objects.equals(cost, 0D)) {
            avg = total / cost;
        }

        if (cost != 0) {
            avg = total / cost;
        }
        Double a = 0D;
        Double d = 0D;
        int f = 0;
        boolean result = Objects.equals(a, d);
        boolean result1 = Objects.equals(a, f);
        // true
        System.out.println(result);
        // false
        System.out.println(result1);
        // true
        System.out.println(a == f);

        System.out.println(a.equals(d));
    }
}
