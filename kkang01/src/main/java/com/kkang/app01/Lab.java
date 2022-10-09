package com.kkang.app01;

public class Lab {
	private final String title;
	private final Class<?> cls;

	public Lab(String title, Class<?> cls) {
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
