package uneed;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/9/25 9:09
 */
public class Lambda {
    public static void main(String[] args) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println("lambda -->");
             }
         });

         // 使用lambda表达式来创建线程
        new Thread(() -> System.out.println("############ lambda表达式 ############"));
        Runnable runnable = () -> System.out.println("############ lambda表达式 ############");
        System.out.println("##############" +runnable+ "###############");
    }
}
