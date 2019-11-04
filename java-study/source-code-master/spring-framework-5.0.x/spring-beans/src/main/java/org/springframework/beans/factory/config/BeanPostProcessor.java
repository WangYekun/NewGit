/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 *
 * <p>ApplicationContexts can autodetect BeanPostProcessor beans in their
 * bean definitions and apply them to any beans subsequently created.
 * Plain bean factories allow for programmatic registration of post-processors,
 * applying to all beans created through this factory.
 *
 * <p>Typically, post-processors that populate beans via marker interfaces
 * or the like will implement {@link #postProcessBeforeInitialization},
 * while post-processors that wrap beans with proxies will normally
 * implement {@link #postProcessAfterInitialization}.
 *
 * @author Juergen Hoeller
 * @since 10.10.2003
 * @see InstantiationAwareBeanPostProcessor
 * @see DestructionAwareBeanPostProcessor
 * @see ConfigurableBeanFactory#addBeanPostProcessor
 * @see BeanFactoryPostProcessor
 */

/**
 * BeanPostProcessor 是Spring框架提供的一个扩展点(不止一个,5个)，能够扩展Spring。
 * 这个接口有很多实现类，这些类加起来仅仅是一种Spring的扩展点。BeanFactoryPostProcessor也是一个扩展点
 * 通过实现BeanPostProcessor,程序员可以手动插手Bean实例化的过程，从而减轻BeanFactory的负担
 * 这个接口可以有多个类实现，形成一个列表，依次执行
 * 比如AOP就是在bean实例后期将切面逻辑织入bean实例中的
 * AOP也是通过BeanPostProcessor 和IOC建立起了联系
 * Spring提供了很多默认的PostProcessor(后置处理器)
 * 这个接口简单，但是实现类复杂
 * Spring默认的实现：
 * 一.ApplicationContextAwareProcessor
 * ACAP ：程序自定义的Bean，实现 ApplicationContextAware 接口时注入 ApplicationContext 对象
 * 二.InitDestroyAnnotationBeanPostProcessor
 * 自定义初始化和销毁方法
 * Spring提供的三种初始化和销毁方法是
 * 1.@Bean指定init-methid,destroy-method
 * 2.Bean实现InitializingBean 接口和实现DisposableBean
 * 3.@PostConstruct(init初始化) @PreDestroy
 * Spring通过这三种方法都能完成对Bean声明周期的回调，原因可通过源码InitDestroyAnnotationBeanPostProcessor
 * 三.InstantiationAwareBeanPostProcessor
 * 四.CommonAnnotationBeanPostProcessor
 * 五.AutowiredAnnotationBeanPostProcessor
 * 1.通过Autowired注入一个Bean
 * 六.RequiredAnnotationBeanPostProcessor
 * 七.BeanValidationPostProcessor
 * 八.AbstractAutoProxyCreator
 */
public interface BeanPostProcessor {

	/**
	 * 在类初始化之前执行
	 * Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 */
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
	 * initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 * or a custom init-method). The bean will already be populated with property values.
	 * The returned bean instance may be a wrapper around the original.
	 * <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
	 * instance and the objects created by the FactoryBean (as of Spring 2.0). The
	 * post-processor can decide whether to apply to either the FactoryBean or created
	 * objects or both through corresponding {@code bean instanceof FactoryBean} checks.
	 * <p>This callback will also be invoked after a short-circuiting triggered by a
	 * {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
	 * in contrast to all other BeanPostProcessor callbacks.
	 * <p>The default implementation returns the given {@code bean} as-is.
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return the bean instance to use, either the original or a wrapped one;
	 * if {@code null}, no subsequent BeanPostProcessors will be invoked
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	 * @see org.springframework.beans.factory.FactoryBean
	 */
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
