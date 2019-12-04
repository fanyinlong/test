package com.zhiyou.model;

public abstract class Animal {

	private int age;

	public abstract void eat();

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
