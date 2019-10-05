package uneed;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/5 11:02
 */
public class SwitchString {

    public static void main(String[] args) {
        // NPE
        method(null);
    }

    public static void method(String param) {
        if (param != null) {
            switch (param) {
                // 肯定不是进入这里
                case "sth":
                    System.out.println("it's sth");
                    // 也不是进入这里
                    break;
                case "null":
                    System.out.println("it's null");
                    // 也不是进入这里
                    break;
                default:
                    System.out.println("default");
            }
        }
        // 进入的是这里(NPE)
        return;
    }

}

