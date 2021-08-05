package com.assignment.favourite.recipes.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.entity.User;
import com.assignment.favourite.recipes.repository.UserRepository;
import com.assignment.favourite.recipes.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public String saveUser(User user) {
		User oldUser = userRepository.findByUserName(user.getUserName());
		
		if (oldUser != null ) {
			return "Con not add, User is already exist";
		} else {
			userRepository.save(user);
			return "Recipe is saved successfully";
		}
	}
}
