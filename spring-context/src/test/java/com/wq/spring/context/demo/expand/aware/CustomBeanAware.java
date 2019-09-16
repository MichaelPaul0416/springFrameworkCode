package com.wq.spring.context.demo.expand.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/25
 * @Description:
 * @Resource:
 */
public class CustomBeanAware implements BeanNameAware,BeanClassLoaderAware,BeanFactoryAware {

	private String registerName;

	private ClassLoader classLoader;

	private BeanFactory beanFactory;

	@Override
	public void setBeanName(String name) {
		this.registerName = name;
		System.out.println("setBeanName-->[" + name + "]");
	}

	public String getRegisterName() {
		return registerName;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public ClassLoader parentLoader(){
		return classLoader.getParent();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public BeanFactory beanFactory(){
		return this.beanFactory;
	}
}
