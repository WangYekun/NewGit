package com.wang.swagger.demo.practice;

import java.util.Arrays;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/25 11:14
 * @description 数组操作
 */
public class ArrayPractice {

    public static void main(String[] args) {
        changeParamAddAndSubtract(3, 5);
        System.out.println("================");
        changeParamMultiplyDivide(3, 5);
        int[] ints = new int[]{1, 2, 3, 4, 5};
        System.out.println("================");
        System.out.println("折半查找,找不到就返回-1的数值 = " + Arrays.binarySearch(ints, 0));
        System.out.println("================");
        for (int anInt : ints) {
            System.out.print("" + anInt + "\t");
        }
        int[][] ints1 = new int[][]{
                {1, 2, 2, 2},
                {9, 8, 7, 8}
        };
    }

    private static void changeParamAddAndSubtract(int a, int b) {
        System.out.println("交换前" + "b = " + b + " a = " + a);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("交换后" + "b = " + b + " a = " + a);
    }

    private static void changeParamMultiplyDivide(int a, int b) {
        System.out.println("交换前" + "b = " + b + " a = " + a);
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("交换后" + "b = " + b + " a = " + a);
    }
}
