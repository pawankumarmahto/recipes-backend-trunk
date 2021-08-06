package com.assignment.favourite.recipes.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.repository.UserRepository;
import com.assignment.favourite.recipes.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public String saveUser(Users user) {
		 Optional<Users> optionalUser = userRepository.findByUserName(user.getUserName());
	        if(optionalUser.isPresent()) {
	        	return "Con not add, User is already exist.";
	        }
	        else {
			userRepository.save(user);
			return "Recipe is saved successfully";
		}
	}
}
