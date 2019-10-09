package uneed;

import java.util.*;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/9 22:40
 */
public class VoAndListMap {
    public static void main(String[] args) {
        BaseBean baseBean = new BaseBean();
        baseBean.setId(111);
        baseBean.setCrtHost("127.0.0.1");
        List<BaseBean> list = new ArrayList<>();
        list.add(baseBean);

        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 111);
        map.put("crtHost", "127.0.01");
        map.put("crtTime", new Date());
        listMap.add(map);

        List<Map<String, Object>> list2Map = new ArrayList<>();
        map = new HashMap<>();
        map.put("id", 111);
        map.put("crtHost", "127.0.01");
        map.put("crtTime", new Date());
        map.put("age", 10);
        list2Map.add(map);
        System.out.println("list map json:" + JSONObject.toJSONString(list2Map));

    }
}
