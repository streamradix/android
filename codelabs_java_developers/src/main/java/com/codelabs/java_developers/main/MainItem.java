package com.codelabs.java_developers.main;

public class MainItem {
	private final String text;
	private final Class<?> cls;

	public MainItem(String text, Class<?> cls) {
		this.text = text;
		this.cls = cls;
	}

	public String getText() {
		return text;
	}

	public Class<?> getCls() {
		return cls;
	}
}
