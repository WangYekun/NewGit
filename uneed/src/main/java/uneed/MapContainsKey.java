package uneed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/21 14:36
 */
public class MapContainsKey {
    public static void main(String[] args) {
        System.out.println("###################### map学习中的containKey()方法 ##################");

        // 定义Map对象
        Map<String, String> map = new HashMap<>(16);

        // 向集合中添加对象
        map.put("apple", "新鲜的苹果");
        map.put("computer", "配置优良的计算机");
        map.put("book", "堆积成山的图书");
        String key = "noKeyBook";
        String key2 = "computer";
        String key3 = "apple";

        // 判断是否包含指定的键值
        boolean contains = map.containsKey(key);

        // 如果条件为真
        if (contains) {

            // 输出信息
            System.out.println("在Map集合中包含键名===>：" + key);
            System.out.println("在Map集合中包含键名===>：" + key2);
            System.out.println("在Map集合中包含键名===>：" + key3);
        } else {
            System.out.println("在Map集合中不包含键名===>:" + key);
            System.out.println("在Map集合中不包含键名===>:" + key2);
            System.out.println("在Map集合中不包含键名===>:" + key3);
        }

        System.out.println("###################### map学习 ##################");

        // 1. 定义集合
        Map<String, String> mapStr = new HashMap<>(16);

        // 2. 往集合里面加元素
        mapStr.put("key", "value");

        // 3. 遍历集合(以增强for遍历)
        Set<String> keys = mapStr.keySet();
        for (String keyCopy : keys) {
            System.out.println("key=========>" + keyCopy + "||value============>" + mapStr.get(keyCopy));
        }

        // 4. 遍历集合(以迭代器遍历)
        Set<String> keyIt = mapStr.keySet();
        Iterator<String> keyIt2 = keyIt.iterator();
        while (keyIt2.hasNext()) {
            String keyLoop = keyIt2.next();
            System.out.println("key=========>" + keyLoop + "||value============>" + mapStr.get(keyLoop));
        }
    }
}
