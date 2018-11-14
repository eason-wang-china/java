package com.eason.spring4.profile;

import org.springframework.stereotype.Service;

@Service
public class YourBean {

	private String value;

	// public YourBean(String value) {
	// super();
	// this.value = value;
	// }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
