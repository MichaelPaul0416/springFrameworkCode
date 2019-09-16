package com.wq.spring.context.demo.tags;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/29
 * @Description:
 * @Resource:
 */
public class ComputerTagParser extends AbstractBeanDefinitionParser {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		return null;
	}

}
