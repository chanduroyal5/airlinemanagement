package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u1 FROM User u1 WHERE u1.userName = :userName AND u1.password = :password")
	User logInUser(@Param("userName") String userName ,@Param("password") String password);
}
