package com.assignment.favourite.recipes.dto;

import java.io.Serializable;
import java.util.Set;

public class UsersDTO implements Serializable {
	
	private static final long serialVersionUID = 1001L;
	private Long userId;
	private String userName;
	private String email;
	private char active;
	private String password;
	private Set<UserRoleDTO> roles;
	public  UsersDTO() {
	}

	public UsersDTO(UsersDTO user) {
		super();
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.active = user.active;
		this.roles = user.roles;
		this.password = user.password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public Set<UserRoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoleDTO> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
