package com.assignment.favourite.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.entity.Recipes;
import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/level2/addUser", method = RequestMethod.POST)
	public String  addUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

}
