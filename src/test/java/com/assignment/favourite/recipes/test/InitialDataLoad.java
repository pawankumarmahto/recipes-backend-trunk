package com.assignment.favourite.recipes.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.assignment.favourite.recipes.controller.UserController;
import com.assignment.favourite.recipes.dto.RoleDTO;
import com.assignment.favourite.recipes.dto.UserRoleDTO;
import com.assignment.favourite.recipes.dto.UsersDTO;
import com.assignment.favourite.recipes.exception.UserException;

@SpringBootTest
public class InitialDataLoad {
	
	@Autowired
	private UserController userController;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	void initialDataLoad() throws UserException {
		
		UserRoleDTO  role = new UserRoleDTO();
		role.setId(1);
		role.setUserRoleId(1);
		role.setUserRoleName("ADMIN");
		Set<UserRoleDTO> roles = new HashSet<>();
		roles.add(role);
		
		UsersDTO user = new UsersDTO();
		user.setUserName("admin");
		user.setPassword(bCryptPasswordEncoder.encode("password"));
		user.setRoles(roles);
		user.setEmail("pawankumarmahto29@gmail.com");
		user.setActive('Y');
		userController.addUser(user);
		
	}

}
