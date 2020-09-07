package com.sbk.signoff.coreapp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "SO_CORE_COMMENT")
public class CommentEntity extends BaseEntity {
	private static final long serialVersionUID = -3259227196635724910L;

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "DOC_SID", unique = true, nullable = false)
	private Long docSid;

	@Column(name = "USER_SID", unique = true, nullable = false)
	private Long userId;

	@Column(name = "COMMENT", nullable = false, length = 1000)
	private String comment;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private String isActive;

	public CommentEntity() {
		super();
	}

	public CommentEntity(Long id, Long docSid, Long userId, String comment, String isActive) {
		this.id = id;
		this.docSid = docSid;
		this.userId = userId;
		this.comment = comment;
		this.isActive = isActive;
	}

	@Override
	@PrePersist
	protected void onCreate() {
		super.onCreate();
	}

	@Override
	@PreUpdate
	protected void onUpdate() {
		super.onUpdate();
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
		return "CommentEntity{" +
				"id=" + id +
				", docSid=" + docSid +
				", userId=" + userId +
				", comment='" + comment + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}
}
