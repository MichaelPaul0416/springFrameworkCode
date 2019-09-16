package com.wq.spring.context.demo.annotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class BaseCondition implements Condition {

	@PostConstruct
	public void condition(){
		System.out.println("this is base condition");
	}

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		return beanFactory.containsBeanDefinition("commonBean");

//		return true;
	}
}
