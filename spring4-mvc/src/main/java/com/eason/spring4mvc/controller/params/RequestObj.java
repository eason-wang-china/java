package com.eason.spring4mvc.controller.params;

public class RequestObj {

	private long id;
	private String name;

	public RequestObj() {
		super();
	}

	public RequestObj(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name + " -- " + id;
	}
}
