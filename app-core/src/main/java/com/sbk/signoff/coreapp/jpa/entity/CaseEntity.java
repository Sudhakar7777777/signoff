package com.sbk.signoff.coreapp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "SO_CORE_CASE")
public class CaseEntity extends BaseEntity {
	private static final long serialVersionUID = -5515529228333017104L;

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SID", unique = true, nullable = false)
	private Long sid;

	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private String isActive;

	public CaseEntity() {
		super();
	}

	public CaseEntity(Long id, Long sid, String name, String isActive) {
		super();
		this.id = id;
		this.sid = sid;
		this.name = name;
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
		return "CaseEntity{" +
				"id=" + id +
				", sid=" + sid +
				", name='" + name + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}
}
