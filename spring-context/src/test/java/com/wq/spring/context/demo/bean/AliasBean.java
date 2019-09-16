package com.wq.spring.context.demo.bean;

/**
 * @Author: wangqiang20995
 * @Date:2019/3/15
 * @Description:
 * @Resource:
 */
public class AliasBean {

	private String name;
	private int age;

	public String alias(){
		return "abs";
	}

	@Override
	public String toString() {
		return "AliasBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
