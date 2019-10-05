package uneed;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/5 11:15
 */
public class IfElseDemo {


    public static void main(String[] args) {
        Man man = new Man();
        findBoyfriend(man);
    }

    public static void findBoyfriend(Man man) {
        if (man.isUgly()) {
            System.out.println("本姑娘是外貌协会的资深会员");
            return;
        }

        if (man.isPoor()) {
            System.out.println("贫贱夫妻百事哀");
            return;
        }

        if (man.isBadTemper()) {
            System.out.println("银河有多远，你就给我滚多远");
            return;
        }

        System.out.println("可以先交往一段时间看看");
    }

}

