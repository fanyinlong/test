package com.zhiyou.model;

public class User {
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", username=" + username
				+ ", password=" + password + "]";
	}
	public User(Integer id, String name, Integer age, String sex, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	
	
}
