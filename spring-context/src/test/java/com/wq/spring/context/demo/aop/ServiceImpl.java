package com.wq.spring.context.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/29
 * @Description:
 * @Resource:
 */
public class ServiceImpl {

	public Map<String, String> display(Object object) {
		Map<String, String> map = new HashMap<>(1);
		map.put(object.getClass().getSimpleName(), object.getClass().getName());

		return map;
	}

	public void withoutAop(String param){
		System.out.println("input param:" + param);
	}

	@Override
	public String toString() {
		return "ServiceImpl{Hello world}";
	}

	public static class ProtoServiceImpl implements ProtoService {

		@Override
		public void service(String query) {
			System.out.println("do proto service");
		}
	}

	public static class AdditionalServiceImpl implements AdditionalService {

		@Override
		public void additional(String add) {
			System.out.println("do additional service");
		}
	}

	public static class ServiceAdvice {

		public void doBefore() {
			System.out.println("do advice before call target method --> doBefore");
		}

		public void afterReturning(JoinPoint joinPoint, Object result) throws Throwable {
			System.out.println("do advice after target method returning[" + joinPoint.getSignature().getName() + " return " + result.getClass().getName() + "]");
		}

		public void doAfter(JoinPoint joinPoint) {
			System.out.println("do advice after call target method --> [" + joinPoint.getSignature().getName() + "]");
		}


		public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
			System.out.println("Name[" + joinPoint.getSignature().getName() + "] around before");
			Object object = joinPoint.proceed();
			System.out.println("Name[" + joinPoint.getSignature().getName() + "] around after");
			return object;
		}

		public void before(JoinPoint joinPoint) throws Throwable {
			System.out.println("do advice before call target method[" + joinPoint.getSignature().getName() + "]");
		}
	}

//	private static ApplicationContext applicationContext
//			= new ClassPathXmlApplicationContext("com.wq.spring.context.demo/ExampleApplicationContext.xml");

//	public static void main(String args[]) {
//		ProtoService protoService = (ProtoService) applicationContext.getBean("protoService");
//		protoService.service("proto query");
//
//		AdditionalService additionalService = (AdditionalService) applicationContext.getBean("protoService");
//		additionalService.additional("pro");
//
//		System.out.println("aop各种增强通知");
//		ServiceImpl service = (ServiceImpl) applicationContext.getBean("serviceBean");
//		System.out.println("---"+service.getClass().equals(ServiceImpl.class));
//		System.out.println(service.display(new ArrayList<>()));
//	}
}
