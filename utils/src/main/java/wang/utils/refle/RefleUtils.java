package wang.utils.refle;

import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 23:00
 * @description 反射工具类
 */
public class RefleUtils {

    public static void main(String[] args) {

        Method[] methods = ReflectUtil.getMethods(RefleUtils.class);
        System.out.println("methods = " + Arrays.asList(methods));

        Method method = ReflectUtil.getMethod(RefleUtils.class, "finalize");
        System.out.println("method = " + method);

        System.out.println("ReflectUtil.newInstance(RefleUtils.class) = " + ReflectUtil.newInstance(RefleUtils.class));
    }
}
