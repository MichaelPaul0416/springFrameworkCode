package com.wq.spring.context.demo;

import com.wq.spring.context.demo.bean.Framework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/11 15:21
 **/
public class ConditionalExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.wq");
        Framework framework = context.getBean("framework", Framework.class);
        System.out.println(framework.wrapper("netty"));
    }
}
