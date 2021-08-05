package com.assignment.favourite.recipes.entity;

import javax.persistence.*;

@Entity
@Table(name="ROLE_TBL")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_Id", updatable = false, nullable = false)
	private Long roleId;
	@Column(name = "role")
	private String role;
	
	public Role() {
		
	}
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
