package wang.utils.num;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;

import java.util.Arrays;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 18:46
 * @description 数组工具类
 */
public class NumUtil {
    public static void main(String[] args) {
        double te1 = 123456.12356;
        double te2 = 123456.128456;
        //结果:123456.12
        Console.log(NumberUtil.round(te1, 2));
        //结果:123456.13
        Console.log(NumberUtil.round(te2, 2));
        String te111 = "123456.123456";
        String te211 = "123456.128456";
        //结果:123456.12
        Console.log(NumberUtil.roundStr(te111, 2));
        //结果:123456.13
        Console.log(NumberUtil.roundStr(te211, 2));
        //光速
        long c = 299792458;
        //299,792,458
        String format = NumberUtil.decimalFormat(",###", c);
        System.out.println("format = " + format);
        System.out.println("NumberUtil.isNumber() = " + NumberUtil.isNumber(te111));
        System.out.println("NumberUtil.isInteger() = " + NumberUtil.isInteger(te111));
        System.out.println("NumberUtil.isDouble() = " + NumberUtil.isDouble(te111));
        System.out.println("NumberUtil.isPrimes() = " + NumberUtil.isPrimes(12));
        System.out.println("NumberUtil.generateRandomNumber() = " + Arrays.toString(NumberUtil.generateRandomNumber(11, 22, 1)));
        System.out.println("NumberUtil.generateBySet() = " + Arrays.toString(NumberUtil.generateBySet(11, 22, 1)));
        System.out.println("NumberUtil.factorial() = " + NumberUtil.factorial(33));
        System.out.println("NumberUtil.sqrt(4) = " + NumberUtil.sqrt(4));
        System.out.println("NumberUtil.divisor() = " + NumberUtil.divisor(22, 4));
        System.out.println("NumberUtil.multiple() = " + NumberUtil.multiple(22, 4));
        System.out.println("NumberUtil.getBinaryStr() = " + NumberUtil.getBinaryStr(22));
        System.out.println("NumberUtil.binaryToInt() = " + NumberUtil.binaryToInt("010101011"));
        System.out.println("NumberUtil.binaryToLong() = " + NumberUtil.binaryToLong("010101010101"));
        System.out.println("NumberUtil.compare() = " + NumberUtil.compare(2, 3));
        System.out.println("NumberUtil.toStr(22) = " + NumberUtil.toStr(22.111));
        System.out.println("NumberUtil.add() = " + NumberUtil.add("1", "0.01"));
        System.out.println("NumberUtil.sub() = " + NumberUtil.sub("1", "0.01"));
        System.out.println("NumberUtil.mul() = " + NumberUtil.mul("1", "0.01"));
        System.out.println("NumberUtil.div() = " + NumberUtil.div("1", "0.01", 0));
    }
}
