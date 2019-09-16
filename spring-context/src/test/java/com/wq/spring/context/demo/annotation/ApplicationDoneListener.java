package com.wq.spring.context.demo.annotation;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: wangqiang20995
 * @Date:2019/7/8
 * @Description:
 * @Resource:
 */
//@Component
public class ApplicationDoneListener implements IBuilder, ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println(this.getClass().getName() + " listening...");
	}

	@Override
	public void doBuilder() {
//		System.out.println("do builder-->" + this.getClass().getName());
	}
}

interface IBuilder {
	void doBuilder();
}

@Component
class ListenerOne extends ApplicationDoneListener {
	{
		System.out.println("listener one");
	}
}

@Component
class ListenerTwo extends ApplicationDoneListener{
	{
		System.out.println("listener two");
	}
}