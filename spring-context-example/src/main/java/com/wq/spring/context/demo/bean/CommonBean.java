package com.wq.spring.context.demo.bean;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/25 17:30
 **/
public class CommonBean {
    public CommonBean() {
        System.out.println("init for common bean");
    }

    public void call() {
        System.out.println("call bean method");
    }
}
