package uneed;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/5 11:45
 */
public class NullPointExceptionDemo {
    public static void main(String[] args) {
        System.out.println("############### NullPointException Description ################");

        /*
        1. 【推荐】防止 NPE，是程序员的基本修养，注意 NPE产生的场景：
        1） 返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生 NPE。
        反例：public int f() { return Integer 对象}， 如果为 null，自动解箱抛 NPE。
        2） 数据库的查询结果可能为 null。
        3） 集合里的元素即使 isNotEmpty，取出的数据元素也可能为 null。
        4） 远程调用返回对象时，一律要求进行空指针判断，防止 NPE。
        5） 对于Session 中获取的数据，建议进行 NPE检查，避免空指针。
        6） 级联调用 obj.getA().getB().getC()；一连串调用，易产生 NPE。
        正例：使用 JDK8的Optional 类来防止 NPE问题。
         */

    }
}
