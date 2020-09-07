package com.sbk.signoff.coreapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

import static com.sbk.signoff.coreapp.common.Constant.MSG_EMPTY;
import static com.sbk.signoff.coreapp.common.Constant.MSG_SIZE_1_30;

//@JsonInclude(value = JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private Long id;

	@NotBlank(message = "userName " + MSG_EMPTY)
	@Size(min = 1, max = 30, message = MSG_SIZE_1_30)
	private String userName;

	@NotBlank(message = "firstName " + MSG_EMPTY)
	private String firstName;

	@NotBlank(message = "lastName " + MSG_EMPTY)
	private String lastName;

	@NotBlank(message = "email " + MSG_EMPTY)
	private String email;

	@NotBlank(message = "phone " + MSG_EMPTY)
	private String phone;

	public User() {
	}

	public User(Long id, String userName, String firstName, String lastName, String email, String phone) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
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
				&& Objects.equals(this.firstName, user.firstName)
				&& Objects.equals(this.lastName, user.lastName)
				&& Objects.equals(this.email, user.email)
				&& Objects.equals(this.phone, user.phone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				this.id,
				this.userName,
				this.firstName,
				this.lastName,
				this.email,
				this.phone);
	}

}
