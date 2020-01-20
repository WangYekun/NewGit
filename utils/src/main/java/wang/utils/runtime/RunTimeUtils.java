package wang.utils.runtime;

import cn.hutool.core.util.RuntimeUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 23:11
 * @description 运行工具类
 */
public class RunTimeUtils {

    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println(str);
    }

}
