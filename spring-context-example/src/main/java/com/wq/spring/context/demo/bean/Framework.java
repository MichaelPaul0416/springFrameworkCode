package com.wq.spring.context.demo.bean;

import com.wq.spring.context.demo.conditional.GodRegistryPlugin;
import com.wq.spring.context.demo.conditional.SpecificFrameworkChooser;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/11 15:26
 **/
@Component
@Conditional(value = {SpecificFrameworkChooser.class})
public class Framework implements GodRegistryPlugin {

    public String wrapper(String frame){
        if(frame == null || frame.length() == 0){
            return "empty framework";
        }
        return String.format("java framework - [%s]",frame);
    }

    @Override
    public boolean registerSelfWithGod() {
        return true;
    }
}
