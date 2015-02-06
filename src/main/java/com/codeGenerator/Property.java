package com.codeGenerator;

public class Property {
	
	private Boolean isPropertyID;
	private String propertyType;
	private String propertyName;

	public Property(String propertyType, String propertyName, Boolean isPropertyID) {
		this.propertyType = propertyType;
		this.propertyName = propertyName;
		this.isPropertyID = isPropertyID;
	}
	
	public Boolean getIsPropertyID() {
		return isPropertyID;
	}

	public void setIsPropertyID(Boolean isPropertyID) {
		this.isPropertyID = isPropertyID;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getMethodName(){
		return this.propertyName.substring(0, 1).toUpperCase() + this.propertyName.substring(1);
	}
}
