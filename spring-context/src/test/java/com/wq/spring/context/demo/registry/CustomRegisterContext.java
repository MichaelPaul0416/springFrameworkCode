package com.wq.spring.context.demo.registry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangqiang20995
 * @Date:2019/2/25
 * @Description:
 * @Resource:
 */
public class CustomRegisterContext {

	private ApplicationContext applicationContext ;

	public static final String APPLICATION_CONFIG_PATH = "com.wq.spring.context.demo/registry/CustomRegisterContext.xml";

	@Before
	public void prepare(){
		applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONFIG_PATH);
	}

	@After
	public void finish(){

	}

	@Test
	public void registry(){
		SimpleBean simpleBean = applicationContext.getBean(SimpleBean.class);
		System.out.println(simpleBean);
	}

}
