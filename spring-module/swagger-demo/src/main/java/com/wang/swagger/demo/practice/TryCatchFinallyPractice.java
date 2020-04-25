package com.wang.swagger.demo.practice;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/25 11:14
 * @description try/catch异常学习
 */
public class TryCatchFinallyPractice {

    /**
     * 主函数 运行时异常和编译时异常不一样，编译时异常必须要编写程序时就要弄异常
     *
     * @param args 主函数参数
     * @throws Exception 抛出异常
     */
    public static void main(String[] args) throws Exception {
        // 最后返回的值
        System.out.println("function(5) = " + tryFunc(5));
        System.out.println("throwFunc(10,0) = " + throwFunc(10, 0));
        System.out.println("throwsFunc(10,0) = " + throwsFunc(10, 0));
        System.out.println("defineException() = " + defineException());
    }

    /**
     * try{}catch(...){}
     *
     * @param param 参数传递
     * @return int类型的值 5
     */
    private static int tryFunc(int param) {
        int p = 3;
        try {
            param = p / 0;
            p++;
        } catch (Exception e) {
            p = p + 2;
            System.out.println("p = " + p);
            return p;
        } finally {
            // 都会返回返回的值
            param = param * 2;
            System.out.println("param = " + param);
        }
        // 暂存catch里面的值
        return param;
    }

    /**
     * throw 跑出一个异常(一般与if使用)
     *
     * @param param1 参数一
     * @param param2 参数二
     * @return int值 有可能是异常
     */
    private static int throwFunc(int param1, int param2) {

        if (param2 == 0) {
            throw new ArithmeticException();
        }
        return param1 / param2;
    }

    /**
     * throws 跑出多个异常 子异常>父异常
     *
     * @param param1 参数一
     * @param param2 参数二
     * @return int值 有可能是异常
     */
    private static int throwsFunc(int param1, int param2) throws ArithmeticException, Exception {
        return param1 / param2;
    }

    /**
     * 自定义异常
     *
     * @return 字符串
     */
    public static String defineException() {
        /*1 编写的异常类然后继承继承运行时异常类 RuntimeException
          2 编写所属异常消息message
          3 调用所属异常类并且编写返回消息message即可
        **/
        return "";
    }

}
