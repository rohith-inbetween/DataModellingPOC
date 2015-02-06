package com.codeGenerator;

import java.util.List;

public class EntityClass {

	private String className;

	private List<Property> properties;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
