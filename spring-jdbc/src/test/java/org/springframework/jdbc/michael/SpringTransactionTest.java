package org.springframework.jdbc.michael;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/24
 * @Description:
 * @Resource:
 */
public class SpringTransactionTest {

	public static void main(String[] args){
		String path = "org/springframework/jdbc/michael/spring-tx.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

		SpringUserService springUserService = (SpringUserService) applicationContext.getBean("userService");

		SpringUsers springUsers = new SpringUsers();
		springUsers.setSex("0");
		springUsers.setName("A");
		springUsers.setAge(1);
		springUsers.setId(1);

		springUserService.save(springUsers);
	}
}
