package com.assignment.favourite.recipes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.dto.UsersDTO;
import com.assignment.favourite.recipes.exception.UserException;
import com.assignment.favourite.recipes.service.UserService;
/**
 * {@link UserController}
 * 
 * User controller to handle the request for Add operation

 * @author Pawan.Mahto
 *
 */

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/level2/addUser", method = RequestMethod.POST)
	public String  addUser(@RequestBody UsersDTO usersDTO) throws UserException{
		logger.info(" In addUser() of  UserController ");
		 userService.saveUser(usersDTO);
		 return "User is added successfully";
	}
}
