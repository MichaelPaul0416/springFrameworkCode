package com.wq.spring.context.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @Author: wangqiang20995
 * @Date:2019/3/15
 * @Description:
 * @Resource:
 */
public class AliasModifier implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		String[] beanNames= registry.getBeanDefinitionNames();
		for(String beanName : beanNames){
			if(beanName.contains("alias") || beanName.contains("Alias")){
				BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
				String method = beanDefinition.getInitMethodName();
				registry.registerAlias(beanName,"abs");
			}
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
