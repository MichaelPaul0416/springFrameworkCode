package com.wq.spring.context.demo.aop.customaop;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/19
 * @Description:
 * @Resource:
 */
public interface ProxyFacade {
	Object invoke(Object... objects) throws Throwable;
}
