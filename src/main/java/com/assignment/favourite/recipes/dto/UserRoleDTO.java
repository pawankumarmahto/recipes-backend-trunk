package com.assignment.favourite.recipes.dto;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {

	private static final long serialVersionUID = 1001L;
	private Integer id;
	
	private Integer userRoleId;
	
	private String userRoleName;

	public UserRoleDTO() {
		
	}
	public UserRoleDTO(Integer id, Integer userRoleId, String userRoleName) {
		this.id = id;
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

}
