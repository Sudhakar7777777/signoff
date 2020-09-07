package com.sbk.signoff.coreapp.api.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "type", "message"})
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class APIStandardError {

	private String code;
	private ErrorType type;
	private String message;

	public APIStandardError() {
	}

	public APIStandardError(String code, ErrorType type, String message) {
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(ErrorType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "APIStandardError{" +
				"code='" + code + '\'' +
				", type=" + type +
				", message='" + message + '\'' +
				'}';
	}
}
