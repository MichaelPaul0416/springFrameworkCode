package com.wq.spring.context.demo.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContext {

	private static AnnotationConfigApplicationContext applicationContext;

	private static Logger logger = LoggerFactory.getLogger(AnnotationApplicationContext.class);

	public static void main(String[] args){
//		applicationContext = new ClassPathXmlApplicationContext("com.wq.spring.context.demo/annotation/annotation_applicationContext.xml");
		applicationContext = new AnnotationConfigApplicationContext("com.wq.spring.context.demo.annotation");

		logger.info("application done...");
		CommonBean commonBean = applicationContext.getBean(CommonBean.class);
		commonBean.show();

		ConditionBean conditionBean = applicationContext.getBean(ConditionBean.class);
		conditionBean.exist();
	}
}
