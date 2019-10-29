package hutool.strconvert;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/29 16:16
 * @description 测试字符转换
 */
public class Dog extends CloneSupport<Dog> {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 深拷贝
        ObjectUtil.cloneByStream(dog);

        // 应用在文本统一化
        String halfConvertFullAngle = "123456789";
        String sbc = Convert.toSBC(halfConvertFullAngle);

        // 结果为："１２３４５６７８９"
        System.out.println("halfConvertFullAngle=========>" + sbc);

        String fullConvertHalfAngle = "１２３４５６７８９";
        String dbc = Convert.toDBC(fullConvertHalfAngle);

        // 结果为"123456789"
        System.out.println("fullConvertHalfAngle=========>" + dbc);

        String a = "我是一个小小的可爱的字符串";
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);

        // 结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        System.out.println("str==>16:::" + hex);

        String hexToStr = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";
        String raw = Convert.hexToStr(hexToStr, CharsetUtil.CHARSET_UTF_8);

        // 注意：在4.1.11之后hexStrToStr将改名为hexToStr
        System.out.println("16==>str:::" + raw);

        String str = "我是一个小小的可爱的字符串";

        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String strToUnicode = Convert.strToUnicode(str);
        System.out.println("strToUnicode==:::" + strToUnicode);

        //结果为："我是一个小小的可爱的字符串"
        String unicodeToStr = Convert.unicodeToStr(strToUnicode);
        System.out.println("unicodeToStr==:::" + unicodeToStr);

    }
}
