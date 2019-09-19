package com.wq.spring.context.demo.aop.customaop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/17
 * @Description:
 * @Resource:
 */
public class JdkProxyBeanPostProcessor implements BeanPostProcessor{


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class clazz = bean.getClass();

		if(!ProxyFacade.class.isAssignableFrom(clazz)){
			System.out.println("bean["+beanName+"]不进行代理...");
			return bean;
		}

		bean = ProxyHandler.getProxy(bean.getClass(),new ProxyHandler((ProxyFacade) bean));
		return bean;
	}
}
