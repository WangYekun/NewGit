package wang.utils.colltion;

import cn.hutool.core.collection.CollUtil;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/16 8:41
 * @description 集合工具类
 */
public class CollUtils {
    public static void main(String[] args) {
        String[] keys = new String[]{"a", "b", "c"};
        Integer[] values = new Integer[]{1, 2, 3};
        Collection key = Arrays.asList(keys);
        Collection value = Arrays.asList(values);
        System.out.println("CollUtil.zip(k, v) >>>>>>>>>>>>>> " + CollUtil.zip(key, value));

        String a = "a,b,c";
        String b = "1,2,3";
        System.out.println("CollUtil.zip(a, b, \",\") >>>>>>>>>>>>> " + CollUtil.zip(a, b, ","));
    }
}
