package com.sbk.signoff.coreapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.sbk.signoff.coreapp.common.Constant.MSG_EMPTY;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_30;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Document {

	private Long id;

	private Long caseSid;

	@NotBlank(message = "name " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String name;

	@NotBlank(message = "type " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String type;

	@NotBlank(message = "size " + MSG_EMPTY)
	private String size;

	@JsonIgnore
	private String isActive;

	public Document() {
	}

	public Document(Long id, Long caseSid, String name, String type, String size, String isActive) {
		this.id = id;
		this.caseSid = caseSid;
		this.name = name;
		this.type = type;
		this.size = size;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCaseSid() {
		return caseSid;
	}

	public void setCaseSid(Long caseSid) {
		this.caseSid = caseSid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", caseSid=" + caseSid +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", size='" + size + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}

}
