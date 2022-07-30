package com.wq.spring.context.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/25 17:33
 **/
@Component
public class BeanRegistryScannerProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        boolean contain = registry.containsBeanDefinition("commonBean");
//        if (contain) {
//            BeanDefinition commonBean = registry.getBeanDefinition("commonBean");
//            System.out.println("remove bean:commonBean/" + commonBean.getBeanClassName());
//            registry.removeBeanDefinition("commonBean");
//        }
    }
}
