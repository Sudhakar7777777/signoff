package com.sbk.signoff.coreapp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static com.sbk.signoff.coreapp.common.Constant.SYSTEM_USER;
import static java.util.Objects.isNull;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 7645126442302811818L;

	@Column(name = "CRT_TS", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "CHG_TS", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(name = "CRT_BY")
	private String createdBy;

	@Column(name = "CHG_BY")
	private String updatedBy;

	public BaseEntity() {
		onCreate();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@PrePersist
	protected void onCreate() {
		initializeTimestamps();
		if (isNull(this.createdBy)) {
			this.createdBy = SYSTEM_USER;
		}
		if (isNull(this.updatedBy)) {
			this.updatedBy = SYSTEM_USER;
		}
	}

	public void initializeTimestamps() {
		created = updated = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}
}
