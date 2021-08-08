package com.assignment.favourite.recipes.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.favourite.recipes.entity.Users;

/**
 * {@link UserRepository}
 * 
 * UserRepository interface is for JPA functionality and to perform CRUD operations.
 * 
 * @author Pawan.Mahto
 */

@Repository
public interface UserRepository  extends JpaRepository<Users, Long>{
	
	public Optional<Users> findByUserName(String userName);

}
