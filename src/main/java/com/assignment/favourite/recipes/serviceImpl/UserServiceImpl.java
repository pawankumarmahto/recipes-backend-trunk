package com.assignment.favourite.recipes.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.exception.UserFoundException;
import com.assignment.favourite.recipes.repository.UserRepository;
import com.assignment.favourite.recipes.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(RecipesServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(Users user) throws UserFoundException{
		logger.info(" In saveUser() of  UserServiceImpl ");
		 Optional<Users> optionalUser = userRepository.findByUserName(user.getUserName());
         if(optionalUser.isPresent()) {
        	throw new  UserFoundException("Con not add, User is already exist.");
         }
         userRepository.save(user);
	}
}
