package com.assignment.favourite.recipes.usercontroller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.assignment.favourite.recipes.controller.UserController;
import com.assignment.favourite.recipes.entity.Role;
import com.assignment.favourite.recipes.entity.Users;
import com.assignment.favourite.recipes.repository.UserRepository;

@SpringBootTest
public class UserTest {

	@MockBean
	private  UserRepository userRepository;
	
	@Autowired
	private UserController userController;
	
	@Test
	public void addIngredientWithNegativeScenario () throws Exception {
		Role  role = new Role();
		role.setRoleId(1l);
		role.setRole("ADMIN");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		Users user = new Users();
		user.setUserName("pawan");
		user.setPassword("password");
		user.setRoles(roles);
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn( Optional.of(user));
		try {  
			userController.addUser(user);
		} catch(Exception e) {
					
		}
	}
	
	@Test
	public void addIngredientWithPositiveScenario () throws Exception {
		Users user = new Users();
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn( Optional.of(user));
		Mockito.when(userRepository.save(Mockito.any(Users.class))).thenReturn(user);
		try {
			String result = userController.addUser(user);
			assertEquals("User is added successfully",result);
		} catch(Exception e) {
			
		}
	}
}
