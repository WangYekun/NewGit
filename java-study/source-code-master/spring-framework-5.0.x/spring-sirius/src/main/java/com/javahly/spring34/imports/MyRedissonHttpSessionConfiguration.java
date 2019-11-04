package com.javahly.spring34.imports;

import com.javahly.spring34.annotation.EnableMyRedissonHttpSession;
import com.javahly.spring34.config.AppConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/11
 * @QQ :1136513099
 * @desc :ImportAware 怎么使用（得到一个注解类的注解的值)
 */
@Configuration
public class MyRedissonHttpSessionConfiguration implements ImportAware {

	private AnnotationMetadata importMetadata ;

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println("ImportAware......");
		this.importMetadata = importMetadata;
		Map<String, Object> map = importMetadata.getAnnotationAttributes(EnableMyRedissonHttpSession.class.getName());
		//转换为AnnotationAttributes这个类型的Map
		AnnotationAttributes attrs = AnnotationAttributes.fromMap(map);
		String value = attrs.getString("value");
		System.out.println(value);
	}
}
