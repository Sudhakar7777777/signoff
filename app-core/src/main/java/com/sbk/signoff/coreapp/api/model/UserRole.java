package com.sbk.signoff.coreapp.api.model;

public enum UserRole {
	ROLE_ADMIN("ADMIN"),
	ROLE_USER("USER");

	private String value;

	UserRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static UserRole fromValue(String value) {
		for(UserRole role : values()) {
			if(role.value.equalsIgnoreCase(value) || role.name().equalsIgnoreCase(value)) {
				return role;
			}
		}
		throw new RuntimeException("UserRole not found : " + value);
	}
}
