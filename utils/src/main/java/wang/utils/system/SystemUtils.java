package wang.utils.system;

import cn.hutool.system.SystemUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 16:00
 * @description 系统工具类
 */
public class SystemUtils {
    public static void main(String[] args) {
        System.out.println("SystemUtil.getJvmSpecInfo().getVersion() = " + SystemUtil.getJvmSpecInfo().getVersion());
        System.out.println("SystemUtil.getUserInfo() = " + SystemUtil.getUserInfo());
        System.out.println("SystemUtil.getHostInfo() = " + SystemUtil.getHostInfo());
    }
}
