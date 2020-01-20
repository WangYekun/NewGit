package wang.utils.strspliter;

import cn.hutool.core.text.StrSpliter;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 14:21
 * @description 字符串切割工具
 */
public class StringCutUtil {

    public static void main(String[] args) {
        String str1 = "a, ,ddd,   ddf";
        List<String> split = StrSpliter.split(str1, ',', 0, true, true);
        System.out.println("split = " + split);
    }
}
