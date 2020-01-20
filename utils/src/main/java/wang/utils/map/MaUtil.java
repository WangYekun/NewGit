package wang.utils.map;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 11:44
 * @description map工具类
 */
public class MaUtil {
    public static void main(String[] args) {
        // 二维数组转换
        Map<Object, Object> colorMap = MapUtil.of(new String[][]{
                {"RED", "#FF0000"},
                {"GREEN", "#00FF00"},
                {"BLUE", "#0000FF"}
        });
        System.out.println("二维数组map = " + colorMap);
        System.out.println("MapUtil.isEmpty(colorMap) = " + MapUtil.isEmpty(colorMap));
    }
}
