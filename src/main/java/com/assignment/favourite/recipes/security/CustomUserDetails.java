package com.assignment.favourite.recipes.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.entity.Users;


public class CustomUserDetails  implements UserDetails {
	
	private Users user;
	public CustomUserDetails( Users user){
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getRoles().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole())). collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
		
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
