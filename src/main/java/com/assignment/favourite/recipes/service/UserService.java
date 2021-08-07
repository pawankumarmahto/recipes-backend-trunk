package com.assignment.favourite.recipes.service;

import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.exception.UserFoundException;

public interface UserService {
	
	public void saveUser(Users user) throws UserFoundException;

}
