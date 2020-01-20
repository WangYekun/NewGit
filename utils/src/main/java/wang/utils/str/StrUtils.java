package wang.utils.str;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/14 19:20
 * @description 字符串工具类
 */
public class StrUtils {
    public static void main(String[] args) {

        int a = 1;
        // aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println("aStr = " + aStr);

        long[] b = {1, 2, 3, 4, 5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println("bStr = " + bStr);

        String[] d = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(d);
        List<?> list = Convert.toList(intArray);
        System.out.println("list = " + list);

        long[] c = {1, 2, 3, 4, 5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        List<?> list2 = Convert.toList(intArray2);
        System.out.println("list2 = " + list2);

        double f = 67556.32;
        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(f);
        System.out.println("digitUppercase = " + digitUppercase);

        Class<?> wrapClass = Integer.class;
        Class<?> unWraped = Convert.unWrap(wrapClass);
        //Integer==>int
        System.out.println("unWraped = " + unWraped);

        //long.class==>Long.class
        Class<?> primitiveClass = long.class;
        Class<?> wraped = Convert.wrap(primitiveClass);
        System.out.println("wraped = " + wraped);
        //昨天
        System.out.println("DateUtil.yesterday()" + DateUtil.yesterday());
        //明天
        System.out.println("DateUtil.tomorrow()" + DateUtil.tomorrow());
        //上周
        System.out.println("DateUtil.lastWeek() " + DateUtil.lastWeek());

        TimeInterval timer = DateUtil.timer();
        //花费毫秒数
        System.out.println("timer.interval() = " + timer.interval());
        //返回花费时间，并重置开始时间
        System.out.println("timer.intervalRestart() = " + timer.intervalRestart());
        //花费分钟数
        System.out.println("timer.intervalMinute() = " + timer.intervalMinute());
        //年龄
        System.out.println("DateUtil.ageOfNow(\"1990-01-30\") = " + DateUtil.ageOfNow("1990-01-30"));
        //是否闰年
        System.out.println("DateUtil.isLeapYear(2017) = " + DateUtil.isLeapYear(2017));

        DateTime dateTime = new DateTime("2020年01月12日", DatePattern.CHINESE_DATE_FORMAT);
        DateTime date = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATE_PATTERN);
        //结果：2017-01-05 12:34:23
        String dateStr = dateTime.toString();
        String date2 = date.toString();
        System.out.println("date2 = " + date2);
        System.out.println("dateStr = " + dateStr);

        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");
        String file = StrUtil.removePrefixIgnoreCase("prasHHGHDSFSDFtty_girl.jpg","HHGHDSFSDFtt");
        String file111 = StrUtil.removeSuffixIgnoreCase("prasHHGHDSFSDFtty_girl.jpg", ".prasHHGHDSFSDFtty_girl");
        System.out.println("file111 = " + file111);
        System.out.println("file = " + file);
        System.out.println("fileName = " + fileName);

        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        System.out.println("strSub1 = " + strSub1);
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        System.out.println("strSub2 = " + strSub2);
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c
        System.out.println("strSub3 = " + strSub3);

        String template = "{}爱{}，就像老鼠爱大米";
        //str -> 我爱你，就像老鼠爱大米
        String str1 = StrUtil.format(template, "我", "你");
        System.out.println("str1 = " + str1);

        int[] startEnd1 = PageUtil.transToStartEnd(1, 10);//[0, 10]

        List<?> startEnd1List = Convert.toList(startEnd1);
        System.out.println("startEnd2 = " + startEnd1List);

        System.out.println("StrFormatter.format(\"this is {} for {}\", \"a\", \"b\") = "
                + StrFormatter.format("this is {} for {}", "a", "b"));
        System.out.println("StrFormatter.format(\"this is \\\\{} for {}\", \"a\", \"b\") = "
                + StrFormatter.format("this is \\{} for {}", "a", "b"));
        System.out.println("StrFormatter.format(\"this is \\\\\\\\{} for {}\", \"a\", \"b\") = "
                + StrFormatter.format("this is \\\\{} for {}", "a", "b"));

    }

}
