package com.assignment.favourite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.favourite.recipes.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);

}
