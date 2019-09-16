package com.wq.spring.context.demo.annotation;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(BaseCondition.class)
@Component
public class ConditionBean {

	public void exist(){
		System.out.println("this is bean is exist");
	}
}
