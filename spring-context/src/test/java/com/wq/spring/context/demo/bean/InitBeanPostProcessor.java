package com.wq.spring.context.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/16
 * @Description:接口的调用顺序，是先调用实例化(postProcessBeforeInstantiation),再调用初始化(postProcessBeforeInitialization)
 * @Resource:
 */
public class InitBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean initialization...[" + beanName + "]");
		return bean;
	}


	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("bean instantiation...[" + beanName + "]");
		return null;
	}
}
