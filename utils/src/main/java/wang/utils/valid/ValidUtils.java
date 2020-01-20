package wang.utils.valid;

import cn.hutool.core.lang.Validator;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 23:52
 * @description 字段验证工具类
 */
public class ValidUtils {
    public static void main(String[] args) {
        // 格式Validator.isXx()；
        System.out.println("Validator.isEmail(\"loolly@gmail.com\") = " + Validator.isEmail("loolly@gmail.com"));
        System.out.println("Validator.isChinese(\"中文\") = " + Validator.isChinese("中文"));
        System.out.println("Validator.isMobile() = " + Validator.isMobile("19973123123"));
    }
}
