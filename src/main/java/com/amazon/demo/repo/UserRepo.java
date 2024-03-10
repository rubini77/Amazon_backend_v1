package com.amazon.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByEmail(String emailId);

	boolean existsByEmail(String email);

}
