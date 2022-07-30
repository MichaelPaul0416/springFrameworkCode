package com.wq.spring.context.demo.conf;

import com.wq.spring.context.demo.bean.CommonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/5/26 15:35
 **/
@Configuration
public class CommonConfiguration {

    @Bean
    public CommonBean commonBean(){
        return new CommonBean();
    }
}
