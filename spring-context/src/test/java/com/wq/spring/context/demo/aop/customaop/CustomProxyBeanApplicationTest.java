package com.wq.spring.context.demo.aop.customaop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/19
 * @Description:
 * @Resource:
 */
public class CustomProxyBeanApplicationTest {

	private ApplicationContext applicationContext;

	public static class ProxyBean implements ProxyFacade{

		public void show(){
			System.out.println("I am show");
		}

		@Override
		public Object invoke(Object... objects) throws Throwable {
			show();
			return null;
		}
	}

	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("com.wq.spring.context.demo/aop/custom_aop_application.xml");
	}

	@Test
	public void test(){
		ProxyFacade proxyBean = (ProxyFacade) applicationContext.getBean("proxyBean");
		try {
			proxyBean.invoke(new Object());
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
