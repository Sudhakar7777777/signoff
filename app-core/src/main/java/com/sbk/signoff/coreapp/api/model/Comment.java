package com.sbk.signoff.coreapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.sbk.signoff.coreapp.common.Constant.MSG_EMPTY;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_1000;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Comment {

	private Long id;

	private Long docSid;

	private Long userId;

	@NotBlank(message = "name " + MSG_EMPTY)
	@Size(min = 1, max = 1000, message = MSG_SIZE_1_1000)
	private String comment;

	@JsonIgnore
	private String isActive;


	public Comment() {
	}

	public Comment(Long id, Long docSid, Long userId, String comment, String isActive) {
		this.id = id;
		this.docSid = docSid;
		this.userId = userId;
		this.comment = comment;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocSid() {
		return docSid;
	}

	public void setDocSid(Long docSid) {
		this.docSid = docSid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", docSid=" + docSid +
				", userId=" + userId +
				", comment='" + comment + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}

}
