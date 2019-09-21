package com;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/8/29 11:16
 */
public class StringReplaceTest {
    public static void main(String[] args) {
        /*System.out.println(StrSubstitutor.replaceSystemProperties("You are running with java.version = " +
                "${java.version} and os.name = ${os.name}."));*/

        //${?:}
        //${?:-}
        Map<String, String> valuesMap = Maps.newHashMap();
        valuesMap.put("name", "吴涛");
        valuesMap.put("code", "凯影");
        String templateString = "The ${name:} jumped over the ${code}.";
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        System.out.println("resolvedString = " + resolvedString);

        /*StrSubstitutor.replaceSystemProperties("You are running with java.version = ${java.version} " +
                "and os.name = ${os.name}.");
        Map<String, Object> params = new HashMap<>();
        params.put("name", "${x}");
        params.put("x", "replaceSystemAttributeValues");
        StrSubstitutor strSubstitutor = new StrSubstitutor(params);
        String hello2 = "${name}";
        System.out.println("============直接替换系统属性值===================");
        System.out.println(strSubstitutor.replace(hello2));

        System.out.println("============设置默认值===================");
        Map values = new HashMap();
        values.put("animal", "quick brown fox");
        values.put("target", "${}");
        String template = "The ${animal} jumped over the ${target}${undefined.number:-1234567890}";
        StrSubstitutor s = new StrSubstitutor(values);
        String sl = s.replace(template);
        System.out.println("sl = " + sl);

        System.out.println("============简单的调用-自定义匹配符===================");
        Map valuesMaps = new HashMap();
        valuesMaps.put("animal", "quick brown fox");
        valuesMaps.put("target", "lazy dog");
        String templateStrings = "The &(animal) jumped over the &(target). &(undefined.number:-1234567890).";
        StrSubstitutor subs = new StrSubstitutor(valuesMaps, "&(", ")", '&');
        String resolvedStrings = subs.replace(templateStrings);
        System.out.println("resolvedStrings = " + resolvedStrings);*/
    }


}
