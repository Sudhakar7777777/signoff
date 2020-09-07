package com.sbk.signoff.coreapp.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sbk.signoff.coreapp.api.model.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_100;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_3;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_30;

@Entity
@Table(name = "SO_CORE_USER")
public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = 3117824690610340628L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "USER_NM", nullable = false, length = 30)
	private String userName;

	@Column(name = "PASSWD", nullable = false, length = 20)
	private String password;

	@Column(name = "TYPE", nullable = false, length = 10)
	private String userType;

	@Column(name = "ROLE", nullable = false, length = 10)
	private String userRole;

	@Column(name = "FIRST_NM", nullable = false, length = 30)
	private String firstName;

	@Column(name = "LAST_NM", nullable = false, length = 30)
	private String lastName;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "PHONE", length = 15)
	private String phone;

	@Column(name = "ADDR", length = 100)
	private String address;

	@Column(name = "STATE", length = 30)
	private String state;

	@Column(name = "COUNTRY", length = 3)
	private String country;

	@Column(name = "ZIP", length = 5)
	private String zip;

	@Column(name = "LAST_LOGIN")
	private Date lastLogin;

	public UserEntity() {
		super();
	}

	public UserEntity(Long id, String userName, String password, String usertype, String userRole,
					  String firstName, String lastName,
					  String email, String phone, String address, String state, String country,
					  String zip, Date lastLogin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userType = usertype;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.lastLogin = lastLogin;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", zip='" + zip + '\'' +
				", lastLogin=" + lastLogin + '\'' +
				", base=" + getUpdatedBy() + "|" + getUpdated() + "|" + getCreatedBy() + "|" + getCreated() +
				'}';
	}
}
