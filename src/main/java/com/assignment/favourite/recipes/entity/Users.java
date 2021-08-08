package com.assignment.favourite.recipes.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id", updatable = false, nullable = false)
	private Long userId;
	
	@Column(name = "user_name", length = 100, nullable = false)
	private String userName;
	private String email;
	private char active;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="USERID_FK")
	private Set<UserRole> userRole = new HashSet<>();
	
	public Users() {
		
	}

	public Users(Users user) {
		super();
		this.userId = user.userId;
		this.userName = user.userName;
		this.email = user.email;
		this.active = user.active;
		this.userRole = user.userRole;
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

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
