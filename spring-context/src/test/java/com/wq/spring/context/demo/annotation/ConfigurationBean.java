package com.wq.spring.context.demo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangqiang20995
 * @Date:2019/7/5
 * @Description:
 * @Resource:
 */
@Configuration
public class ConfigurationBean {


	static class ExampleBean{
		{
			System.out.println("init example...");
		}
	}

	@Bean
	public ExampleBean bean1(){
		return new ExampleBean();
	}

//	@Bean ExampleBean bean2(){
//		return new ExampleBean();
//	}
}
