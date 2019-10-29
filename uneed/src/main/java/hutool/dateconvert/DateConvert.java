package hutool.dateconvert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/29 16:44
 * @description 时间转换
 */
public class DateConvert {
    public static void main(String[] args) {
        long a = 4535345;
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);

        // 结果为：75
        System.out.println("secondConvertToMinutes:::" + minutes);

        double money = 67556.32;
        String digitUppercase = Convert.digitToChinese(money);

        // 结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        System.out.println("digitUppercase:::" + digitUppercase);
        System.out.println("################################# 原始类和包装类转换 ##############################");

        // 去包装
        Class<?> wrapClass = Double.class;
        Class<?> unWarped = Convert.unWrap(wrapClass);

        // 结果为：int.class
        System.out.println("wrapCl?ass:::" + unWarped);

        // 包装
        Class<?> primitiveClass = long.class;
        Class<?> warped = Convert.wrap(primitiveClass);

        // 结果为：Long.class
        System.out.println("warped:::" + warped);

        // 当前时间
        Date date = DateUtil.date();
        System.out.println(date);

        // 当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println(date2);

        // 当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date3);

        // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);

        // 当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);

        TimeInterval timer = DateUtil.timer();

        //---------------------------------
        //-------这是执行过程
        //---------------------------------

        //花费毫秒数
        timer.interval();

        //返回花费时间，并重置开始时间
        timer.intervalRestart();

        //花费分钟数
        timer.intervalMinute();
    }
}
