package uneed;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/9/26 22:28
 * sql学习
 */
public class Sql {
    public static void main(String[] args) {
        // 时间格式:年-月-日 时:分:秒
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local date time ===>" + localDateTime);

        LocalDate localDate = LocalDate.now();
        /*XX年-XX月-XX日*/
        System.out.println("local date ===>" + localDate);
        System.out.println("###########################################");
        /*
        pk_ 即primary key；uk_ 即 unique key；idx_ 即index的简称
        对象 年龄区间 类型 字节 表示范围
        人 150岁之内 tinyint unsigned 1 无符号值：0到255
        龟 数百岁 smallint unsigned 2 无符号值：0到65535
        恐龙化石 数千万年 int unsigned 4 无符号值：0到约42.9亿
        太阳 约50亿年 bigint unsigned 8 无符号值：0到约10的19次方
        * */
    }
}
