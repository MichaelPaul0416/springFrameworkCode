package com.wq.spring.context.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommonBean {

	@Autowired
	private CommonService commonService;
	public void show() {
		System.out.println("this is common bean register by Annotation:" + Component.class.getName());
		commonService.service();
	}

	@PostConstruct
	public void afterConstruct(){
		System.out.println("post do something after construct");
	}
}
