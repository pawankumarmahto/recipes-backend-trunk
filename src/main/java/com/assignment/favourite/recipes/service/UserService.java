package com.assignment.favourite.recipes.service;

import com.assignment.favourite.recipes.dto.UsersDTO;
import com.assignment.favourite.recipes.exception.UserException;

public interface UserService {
	
	public void saveUser(UsersDTO usersDTO) throws UserException;

}
