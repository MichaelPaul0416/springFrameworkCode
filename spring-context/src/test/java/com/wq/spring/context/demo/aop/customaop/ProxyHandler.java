package com.wq.spring.context.demo.aop.customaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/19
 * @Description:
 * @Resource:
 */
public class ProxyHandler implements InvocationHandler {

	private ProxyFacade proxyFacade;

	public ProxyHandler(ProxyFacade proxyFacade){
		this.proxyFacade = proxyFacade;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用方法:" + method.getName());
		Object object = method.invoke(proxyFacade,args);
		System.out.println("方法调用结束:" + method.getName());
		return object;
	}

	public static Object getProxy(Class<?> subject,ProxyHandler proxyHandler){
		//获取所有实现接口
		Class[] inf = subject.getInterfaces();
		return Proxy.newProxyInstance(ProxyHandler.class.getClassLoader(),inf,proxyHandler);
	}
}
