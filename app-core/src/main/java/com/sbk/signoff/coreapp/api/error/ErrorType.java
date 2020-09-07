package com.sbk.signoff.coreapp.api.error;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
	APP,
	SYSTEM;

	@JsonValue
	@Override
	public String toString() {
		return name();
	}

	public static ErrorType fromValue(String value) {
		try {
			return valueOf(value);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
}
