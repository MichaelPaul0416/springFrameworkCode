package com.wq.spring.context.demo.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/16
 * @Description:
 * @Resource:
 */
public class AopContextApplicationTest {

	private ApplicationContext applicationContext;

	private String path = "com.wq.spring.context.demo/aop/aop_context_application.xml";

	@Before
	public void prepare(){
		this.applicationContext = new ClassPathXmlApplicationContext(path);
	}

	@Test
	public void commonAop(){
		ServiceImpl service = (ServiceImpl) applicationContext.getBean("serviceBean");
		System.out.println(service.getClass().equals(ServiceImpl.class));
		System.out.println(service.getClass().getName());
//		System.out.println(service);
		System.out.println(service.display("hello"));
		service.withoutAop("aop");
	}
}
