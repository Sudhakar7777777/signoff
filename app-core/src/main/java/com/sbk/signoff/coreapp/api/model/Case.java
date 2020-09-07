package com.sbk.signoff.coreapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.sbk.signoff.coreapp.common.Constant.MSG_EMPTY;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_30;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Case {

	private Long id;

	private Long sid;

	@NotBlank(message = "name " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String name;

	@JsonIgnore
	private String isActive;

	public Case() {
	}

	public Case(Long id, Long sid, String name, String isActive) {
		this.id = id;
		this.sid = sid;
		this.name = name;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Case{" +
				"id=" + id +
				", sid=" + sid +
				", name='" + name + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}

}
