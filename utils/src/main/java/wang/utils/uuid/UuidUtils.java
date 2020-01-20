package wang.utils.uuid;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 23:14
 * @description uuid工具
 */
public class UuidUtils {
    public static void main(String[] args) {
        System.out.println("IdUtil.randomUUID() = " + IdUtil.randomUUID());
        System.out.println("IdUtil.simpleUUID() = " + IdUtil.simpleUUID());
        System.out.println("ObjectId.next() = " + ObjectId.next());
        System.out.println("IdUtil.objectId() = " + IdUtil.objectId());
        //参数1为终端ID //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        System.out.println("snowflake.nextId() = " + snowflake.nextId());

    }
}
