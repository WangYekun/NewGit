package wang.utils.regular;

import cn.hutool.core.util.ReUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/9 19:28
 * @description 正则表达式工具
 */
public class RegularUtil {

    /**
     * 20190101122312 ===> 2019-01-01 12:23:12
     *
     * @param yyyyMMdd 20190101122312
     * @return
     */
    public static String convertTime(String yyyyMMdd) {
        String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
        yyyyMMdd = yyyyMMdd.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
        return yyyyMMdd;
    }


    /**
     * 20190101122312 ===> 2019/01/01 12:23:12
     *
     * @param yyyyMMdd 20190101122312
     * @return
     */
    public static String convertDate(String yyyyMMdd) {
        String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
        yyyyMMdd = yyyyMMdd.replaceAll(reg, "$1/$2/$3 $4:$5");
        return yyyyMMdd;
    }


    public static void main(String[] args) {
        String strTime = "20190101122312";
        System.out.println(convertTime(strTime));
        System.out.println(convertDate(strTime));

        String escape = ReUtil.escape("我有个$符号{}");
        System.out.println("escape = " + escape);
        String content = "1234";
        String replaceAll = ReUtil.replaceAll(content, "(\\d+)", "->$1<-");
        System.out.println("replaceAll = " + replaceAll);
        System.out.println("ReUtil.extractMulti(\"(\\\\w)aa(\\\\w)\", content, \"$1-$2\") = " + ReUtil.extractMulti("(\\w)aa(\\w)", "aa", "$1-$2"));
    }

}
