package com.wq.spring.context.demo.registry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Author: wangqiang20995
 * @Date:2019/2/25
 * @Description:
 * @Resource:
 */
public class CustomBeanRegistry implements BeanDefinitionRegistryPostProcessor, ResourceLoaderAware {

	private ResourceLoader resourceLoader;

	private static final String RESOURCE_PROPERTIES = "/com.wq.spring.context.demo/registry/beanRegistry.properties";

	private static final String SPLITER_FOR_SIMPLEBEAN = ",";

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		Resource resource = this.resourceLoader.getResource(RESOURCE_PROPERTIES);

		InputStream inputStream = null;
		try {
			inputStream = resource.getInputStream();
			Properties properties = new Properties();
			properties.load(inputStream);

			String allBeans = properties.getProperty("allBeans");

			if (StringUtils.isEmpty(allBeans)) {
				return;
			}

			for (String beanName : allBeans.split(SPLITER_FOR_SIMPLEBEAN)) {
				GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
				String beanClass = properties.getProperty(beanName + ".class");
				beanDefinition.setBeanClass(Class.forName(beanClass));

				beanDefinition.getPropertyValues().add("name", properties.getProperty(beanName + ".name"));
				beanDefinition.getPropertyValues().add("address", properties.getProperty(beanName + ".address"));
				beanDefinition.getPropertyValues().add("age", Integer.parseInt(properties.getProperty(beanName + ".age")));

				String[] cars = properties.getProperty(beanName + ".cars").split(SPLITER_FOR_SIMPLEBEAN);
				List<String> list = Arrays.asList(cars);

				beanDefinition.getPropertyValues().add("cars", list);

				registry.registerBeanDefinition(beanName, beanDefinition);
				System.out.println("bean-->[" + beanName + "]注册完成");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("关闭文件流异常");
				}
			}
		}

	}


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("do nothing");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}
