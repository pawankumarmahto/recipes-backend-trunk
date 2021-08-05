package com.assignment.favourite.recipes.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.assignment.favourite.recipes.entity.User;
import com.assignment.favourite.recipes.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserRepository  userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user==null) {
			throw new UsernameNotFoundException("");
		}
		return new CustomUserDetails(user);
		
	}

}
