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
import com.assignment.favourite.recipes.dto.UserRoleDTO;
import com.assignment.favourite.recipes.dto.UsersDTO;
import com.assignment.favourite.recipes.entity.Role;
import com.assignment.favourite.recipes.entity.UserRole;
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
		UserRoleDTO  roleDTO = new UserRoleDTO();
		roleDTO.setId(1);
		roleDTO.setUserRoleId(1);
		roleDTO.setUserRoleName("ADMIN");
		Set<UserRoleDTO> roles = new HashSet<>();
		roles.add(roleDTO);
		
		UsersDTO userDto = new UsersDTO();
		userDto.setUserName("admin");
		userDto.setPassword("password");
		userDto.setRoles(roles);
		
		UserRole  role = new UserRole();
		role.setId(1);
		role.setUserRoleId(1);
		role.setUserRoleName("ADMIN");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(role);
		
		Users user = new Users();
		user.setUserName("admin");
		user.setPassword("password");
		user.setRole(userRoles);
		
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn( Optional.of(user));
		try {  
			UsersDTO userDTO = new UsersDTO();
			userController.addUser(userDTO);
		} catch(Exception e) {
					
		}
	}
	
	@Test
	public void addIngredientWithPositiveScenario () throws Exception {
		UserRoleDTO  roleDTO = new UserRoleDTO();
		roleDTO.setId(1);
		roleDTO.setUserRoleId(1);
		roleDTO.setUserRoleName("ADMIN");
		Set<UserRoleDTO> roles = new HashSet<>();
		roles.add(roleDTO);
		
		UsersDTO userDto = new UsersDTO();
		userDto.setUserName("admin");
		userDto.setPassword("password");
		userDto.setRoles(roles);
		
		UserRole  role = new UserRole();
		role.setId(1);
		role.setUserRoleId(1);
		role.setUserRoleName("ADMIN");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(role);
		
		Users user = new Users();
		user.setUserName("admin");
		user.setPassword("password");
		user.setRole(userRoles);
		
		
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn( Optional.of(new Users()));
		Mockito.when(userRepository.save(Mockito.any(Users.class))).thenReturn(user);
		try {
			UsersDTO userDTO = new UsersDTO();
			String result = userController.addUser(userDTO);
			assertEquals("User is added successfully",result);
		} catch(Exception e) {
			
		}
	}
}
