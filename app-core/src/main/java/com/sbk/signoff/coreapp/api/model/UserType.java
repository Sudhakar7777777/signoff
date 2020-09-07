package com.sbk.signoff.coreapp.api.model;

public enum UserType {
	TYPE_ADMIN("ADMIN"),
	TYPE_STUDENT("STUDENT"),
	TYPE_TEACHER("TEACHER"),
	TYPE_OTHER("OTHER");

	private String value;

	UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static UserType fromValue(String value) {
		for(UserType type : values()) {
			if(type.value.equalsIgnoreCase(value) || type.name().equalsIgnoreCase(value)) {
				return type;
			}
		}
		throw new RuntimeException("UserType not found : " + value);
	}
}
