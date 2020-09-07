package com.sbk.signoff.coreapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

import static com.sbk.signoff.coreapp.common.Constant.MSG_EMPTY;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_100;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_15;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_20;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_3;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_30;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_5;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_50;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User {

	private Long id;

	@NotBlank(message = "userName " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String userName;

	@NotBlank(message = "password " + MSG_EMPTY)
	@Size(min = 1, max = 20, message = MSG_SIZE_1_20)
	private String password;

	@NotBlank(message = "firstName " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String firstName;

	@NotBlank(message = "lastName " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String lastName;

	@NotBlank(message = "email " + MSG_EMPTY)
	@Size(min = 1, max = 50, message = MSG_SIZE_1_50)
	private String email;

	@Size(min = 1, max = 15, message = MSG_SIZE_1_15)
	private String phone;

	@Size(min = 1, max = 100, message = MSG_SIZE_1_100)
	private String address;

	@Size(min = 2, max = 30, message = MSG_SIZE_1_30)
	private String state;

	@Size(min = 3, max = 3, message = MSG_SIZE_1_3)
	private String country;

	@Size(min = 5, max = 5, message = MSG_SIZE_1_5)
	private String zip;

	@JsonIgnore
	private Date lastLogin;

	public User() {
	}

	public User(Long id, String userName, String password, String firstName, String lastName, String email,
				String phone, String address, String state, String country, String zip, Date lastLogin) {
		this.id = id;
		this.userName = userName;
		this.password = password;
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
		return "User{" +
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
				", lastLogin=" + lastLogin +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(this.id, user.id)
				&& Objects.equals(this.userName, user.userName)
				&& Objects.equals(this.password, user.password)
				&& Objects.equals(this.firstName, user.firstName)
				&& Objects.equals(this.lastName, user.lastName)
				&& Objects.equals(this.email, user.email)
				&& Objects.equals(this.phone, user.phone)
				&& Objects.equals(this.address, user.address)
				&& Objects.equals(this.state, user.state)
				&& Objects.equals(this.country, user.country)
				&& Objects.equals(this.zip, user.zip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				this.id,
				this.userName,
				this.password,
				this.firstName,
				this.lastName,
				this.email,
				this.phone,
				this.address,
				this.state,
				this.country,
				this.zip
		);
	}

}
