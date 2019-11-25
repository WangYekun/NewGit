package study10;

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
        Double cost = 0.0E00;
        if (Objects.equals(cost, 0)) {
        }

        Double a = 0D;
        Double d = 0D;
        int f = 0;
        boolean result1 = Objects.equals(a, f);
        // true
        System.out.println(true);
        // false
        System.out.println(result1);
    }
}
