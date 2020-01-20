package wang.utils.array;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 18:27
 * @description 数据工具类
 */
public class ArrayListUtils {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1, 2, 2, 2};
        System.out.println("ArrayUtil.isEmpty(a) = " + ArrayUtil.isEmpty(a));
        System.out.println("ArrayUtil.isEmpty(b) = " + ArrayUtil.isEmpty(b));
        int[] a1 = {1, 2};
        Integer[] a2 = {1, 2};
        byte[] bytes = {1, 2, 1};
        System.out.println("ArrayUtil.isNotEmpty(a1) = " + ArrayUtil.isNotEmpty(a1));
        System.out.println("ArrayUtil.toString(a1) = " + ArrayUtil.toString(bytes));
        System.out.println("ArrayUtil.join() = " + ArrayUtil.join(bytes, "<<<>>>"));
        System.out.println("ArrayUtil.isArray() = " + ArrayUtil.isArray(bytes));
        System.out.println("ArrayUtil.unWrap(a1) = " + Arrays.toString(ArrayUtil.unWrap(a2)));
        System.out.println("ArrayUtil.wrap(a2) = " + Arrays.toString(ArrayUtil.wrap(a1)));
    }
}
