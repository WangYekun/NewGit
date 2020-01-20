package wang.utils.url;

import cn.hutool.core.util.URLUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 22:56
 * @description URL解析工具
 */
public class UrlUtils {

    public static void main(String[] args) {
        String url = "http://www.hutool.cn//aaa/bbb";
        String normalize = URLUtil.normalize(url);
        // 结果为：http://www.hutool.cn/aaa/bbb
        System.out.println("normalize111 = " + normalize);

        url = "http://www.hutool.cn//aaa/\\bbb?a=1&b=2";
        normalize = URLUtil.normalize(url);
        // 结果为：http://www.hutool.cn/aaa/bbb?a=1&b=2
        System.out.println("normalize222 = " + normalize);

        String body = "366466 - 副本.jpg";
        String encode = URLUtil.encode(body);
        // 结果为：366466%20-%20%E5%89%AF%E6%9C%AC.jpg
        System.out.println("encode = " + encode);
    }
}
