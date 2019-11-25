package study11.parseIntAndvalueOf;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/25 11:33
 * @description 比较parseInt和valueOf的区别
 */
public class ParseIntAndValueOf {
    public static void main(String[] args) {
        System.out.println("############# ParseIntAndValueOf ############");

        String a = "11";
        // 默认十进制 结果是 11
        System.out.println(Integer.parseInt(a));

        // 选择2进制 结果是3
        System.out.println(Integer.parseInt(a, 2));

        // 选择8进制 结果是9
        System.out.println(Integer.parseInt(a, 8));


        String s1 = "1000";
        String s2 = "1000";
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        int n3 = Integer.valueOf(s1);
        int n4 = Integer.valueOf(s2);

        if (n1 == n2) {
            System.out.println("Integer.parseInt(s1) == Integer.parseInt(s2)");
        }

        if (n3 == n4) {
            System.out.println("Integer.valueOf(s3) == Integer.valueOf(s4)");
        }

        /*
        * Integer.valueOf(s) 源码
        * public static Integer valueOf(String s) throws NumberFormatException {
          return Integer.valueOf(parseInt(s, 10));
        * */

        /*
        *
        * public static Integer valueOf(int i) {
          if (i >= IntegerCache.low && i <= IntegerCache.high)
          return IntegerCache.cache[i + (-IntegerCache.low)];
          return new Integer(i);
          }
        * */

        /*
         * Integer.valueOf(s)在Integer.parseInt(s)的计算的基础上，
         * 将int类型的数值转换成了Integer类型，这样转换的意义大家也应该都知道，
         * 就是基本类型的包装类型是引用类型。所以单单为了为了得到一个int值，
         * 就用Integer.parseInt(s)就行了。如果为了得到包装类型就用Integer.valueOf(s)。
         * 毕竟缓存了一部分数值，可以加强点儿性能。
         * */
    }
}
