package com.assignment.favourite.recipes;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.favourite.recipes.dto.UserRoleDTO;
import com.assignment.favourite.recipes.dto.UsersDTO;
import com.assignment.favourite.recipes.service.UserService;

@Component
public class InsertInitialUserRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(InsertInitialUserRunner.class);
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void insertInitialUser() throws Exception {
		logger.info("Inserting initial user details .....");
		Set<UserRoleDTO> roles = new HashSet<>();
		
		UserRoleDTO role = new UserRoleDTO();
		role.setUserRoleName("ADMIN");
		role.setUserRoleId(1);
		roles.add(role);
		
		UsersDTO user = new UsersDTO();
		user.setUserName("admin");
		user.setPassword("password");
		user.setRoles(roles);
		
		userService.saveUser(user);
		
		logger.info("Inserted initial user details !");

	}
}
