package com.wq.spring.context.demo.conditional;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;

import java.util.Arrays;

/**
 * @author:zhizong.wq
 * @desc:
 * @date: 2022/1/11 15:33
 **/
public class SpecificFrameworkChooser implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String metaStr = JSONObject.toJSONString(metadata);
        System.out.println("<metadata>:" + metaStr);
        System.out.println("<beanDefinitions>:" + Arrays.asList(context.getRegistry().getBeanDefinitionNames()));
        AnnotationMetadataReadingVisitor visitor = (AnnotationMetadataReadingVisitor) metadata;
        String[] interfaceNames = visitor.getInterfaceNames();
        boolean useGod = Arrays.asList(interfaceNames).contains(GodRegistryPlugin.class.getName());
        if (!useGod) {
            return false;
        }

        Class<?> pluginClass = null;
        try {
            pluginClass = context.getClassLoader().loadClass(visitor.getClassName());
        } catch (ClassNotFoundException e) {
            System.out.println("class:[" + visitor.getClassName() + "] not exists");
            return false;
        }

        try {
            useGod = ((GodRegistryPlugin)pluginClass.newInstance()).registerSelfWithGod();
            System.out.println("<use god>:"+useGod);
            return useGod;
        } catch (Exception e) {
            System.out.println("call god error:" + e.getMessage());
            return false;
        }

    }
}
