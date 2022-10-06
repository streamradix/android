package com.radix.garage.main;

public class Topic {
	private String title;
	private Class<?> cls;

	public Topic(String title, Class<?> cls) {
		this.title = title;
		this.cls = cls;
	}

	public String getTitle() {
		return title;
	}

	public Class<?> getCls() {
		return cls;
	}
}