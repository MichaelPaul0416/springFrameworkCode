package com.wq.spring.context.demo.tags;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/29
 * @Description:
 * @Resource:
 */
public class ComputerNameSpaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("computer",new ComputerTagParser());
	}
}
