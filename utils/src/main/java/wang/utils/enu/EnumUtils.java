package wang.utils.enu;

import cn.hutool.core.util.EnumUtil;

import java.util.List;
import java.util.Map;


/**
 * 定义枚举
 *
 * @author WangYekun
 */
public enum EnumUtils {

    TEST1("type1"), TEST2("type2"), TEST3("type3");

    private EnumUtils(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return this.type;
    }

    public static void main(String[] args) {
        List<String> names = EnumUtil.getNames(EnumUtils.class);
        System.out.println("names = " + names);
        List<Object> types = EnumUtil.getFieldValues(EnumUtils.class, "type");
        System.out.println("types = " + types);
        Map<String, EnumUtils> enumMap = EnumUtil.getEnumMap(EnumUtils.class);
        System.out.println("enumMap.get(\"TEST1\") = " + enumMap.get("TEST1"));
        Map<String, Object> enumMap1 = EnumUtil.getNameFieldMap(EnumUtils.class, "type");
        System.out.println("enumMap.get(\"TEST1\") = " + enumMap1.get("TEST1"));
    }
}
