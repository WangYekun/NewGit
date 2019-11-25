package com.javahly.spring72.myBeanFactotyPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/23
 * @QQ :1136513099
 * @desc :
 */
@Component
public class MyBeanFactotyPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		GenericBeanDefinition definition = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexService");
		//改变类的注入模型，而不是用field.set,使用Set方法注入
		definition.setAutowireMode(2);

	}
}
