package com.wq.spring.context.demo.registry;

import java.util.List;

/**
 * @Author: wangqiang20995
 * @Date:2019/2/25
 * @Description:
 * @Resource:
 */
public class SimpleBean {

	private String name;

	private String address;

	private int age;

	private List<String> cars;

	@Override
	public String toString() {
		return "SimpleBean{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", age=" + age +
				", cars=" + cars +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getCars() {
		return cars;
	}

	public void setCars(List<String> cars) {
		this.cars = cars;
	}
}
