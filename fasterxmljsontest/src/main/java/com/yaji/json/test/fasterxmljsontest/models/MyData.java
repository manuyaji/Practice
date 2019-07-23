package com.yaji.json.test.fasterxmljsontest.models;

public class MyData {
	
	private String name;
	private int age;
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
	@Override
	public String toString() {
		return "MyData [name=" + name + ", age=" + age + "]";
	}
}
