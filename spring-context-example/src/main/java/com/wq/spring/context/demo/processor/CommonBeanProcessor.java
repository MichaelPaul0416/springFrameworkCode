package com.wq.spring.context.demo.processor;

import com.wq.spring.context.demo.bean.CommonBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/25 17:31
 **/
@Component
public class CommonBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CommonBean) {
            System.out.println("not init for bean:" + beanName + "/" + bean.getClass().getName());
            return null;
        }
        return bean;
    }
}
