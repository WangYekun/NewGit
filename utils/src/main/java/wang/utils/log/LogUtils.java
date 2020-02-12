package wang.utils.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 14:58
 * @description 日志门面工具类
 */
public class LogUtils {
    private static final Log LOG_FACTORY = LogFactory.get(LogUtils.class);

    public static void main(String[] args) {
        StaticLog.info("This is static {} log", LogUtils.class);
        LOG_FACTORY.info("This is static {} log", LogUtils.class);
    }
}
