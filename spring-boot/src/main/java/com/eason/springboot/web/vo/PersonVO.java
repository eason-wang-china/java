package com.eason.springboot.web.vo;

public class PersonVO {
	private String name;
	private Integer age;

	public PersonVO() {
		super();
	}

	public PersonVO(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
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

}
