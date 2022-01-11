package com.wq.spring.context.demo.conditional;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/11 15:58
 **/
public interface GodRegistryPlugin {
    /**
     * 配合{@link SpecificFrameworkChooser}使用
     * @return
     */
    boolean registerSelfWithGod();
}
