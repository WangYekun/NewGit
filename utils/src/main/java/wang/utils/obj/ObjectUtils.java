package wang.utils.obj;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.ObjectUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 22:40
 * @description 对象工具类
 */
public class ObjectUtils {
    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        String c = null;
        String d = "";
        String e = "";
        int f = 1;
        String g ="2\"1 / 4 Óğò\"3 / 4";
        System.out.println("ObjectUtil.equal(a,b) = " + ObjectUtil.equal(a, b));
        System.out.println("ObjectUtil.equal(c,d) = " + ObjectUtil.equal(d, e));
        System.out.println("ObjectUtil.length() = " + ObjectUtil.length(b));
        System.out.println("ObjectUtil.contains() = " + ObjectUtil.contains(d, ""));
        System.out.println("ObjectUtil.isNull() = " + ObjectUtil.isNull(c));
        System.out.println("ObjectUtil.isNotNull() = " + ObjectUtil.isNotNull(a));
        System.out.println("ObjectUtil.isBasicType() = " + ObjectUtil.isBasicType(f));
        System.out.println("EscapeUtil.unescape() = " + EscapeUtil.unescape(a));
        System.out.println("EscapeUtil.unescape() = " + EscapeUtil.safeUnescape(g));
        System.out.println("EscapeUtil.unescape() = " + EscapeUtil.escape(g));
    }
}
