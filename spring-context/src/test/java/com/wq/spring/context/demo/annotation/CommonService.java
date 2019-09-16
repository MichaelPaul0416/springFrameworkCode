package com.wq.spring.context.demo.annotation;

import org.springframework.stereotype.Component;

/**
 * @Author: wangqiang20995
 * @Date:2019/7/2
 * @Description:
 * @Resource:
 */
@Component
public class CommonService {

	public void service(){
		System.out.println("show simple service");
	}
}
