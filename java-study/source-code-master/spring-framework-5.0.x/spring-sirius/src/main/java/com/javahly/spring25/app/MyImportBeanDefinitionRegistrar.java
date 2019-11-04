package com.javahly.spring25.app;

import com.javahly.spring25.dao.IndexDao;
import com.javahly.spring25.test.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/3
 * @QQ :1136513099
 * @desc :
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	//registry注册bd
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
		//这里bd的类型为IndexDao.class
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		beanDefinition.setBeanClass(MyFactoryBean.class);
		//添加构造方法，根据名字找到添加的类型,
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.javahly.spring25.dao.IndexDao");
		registry.registerBeanDefinition("indexDao",beanDefinition);


	}
}
