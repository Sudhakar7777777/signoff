package com.sbk.signoff.coreapp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "SO_CORE_DOCUMENT")
public class DocumentEntity extends BaseEntity {
	private static final long serialVersionUID = -7529091962667500887L;

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "CASE_SID", unique = true, nullable = false)
	private Long caseSid;

	@Column(name = "NAME", nullable = false, length = 30)
	private String name;

	@Column(name = "TYPE", nullable = false, length = 30)
	private String type;

	@Column(name = "SIZE", nullable = false, length = 30)
	private String size;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private String isActive;

	public DocumentEntity() {
		super();
	}

	public DocumentEntity(Long id, Long caseSid, String name, String type, String size, String isActive) {
		this.id = id;
		this.caseSid = caseSid;
		this.name = name;
		this.type = type;
		this.size = size;
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
		return "DocumentEntity{" +
				"id=" + id +
				", caseSid=" + caseSid +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", size='" + size + '\'' +
				", isActive='" + isActive + '\'' +
				'}';
	}
}
