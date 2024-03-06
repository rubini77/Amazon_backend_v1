package com.amazon.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.demo.model.User;
import com.amazon.demo.service.UserService;
import com.amazon.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userrepo;
	
	@Override
	public User saveUserInfo(User user) {
		
		User savedEntity = userrepo.save(user);
		
		
		return savedEntity;
	}


		@Override
		public boolean checkUser(String email,String password) {
			
			User user =userrepo.findByEmail(email);
			if(user!= null && user.getPassword().equals(password)) {
				return true;
			}
			else
				return false;
	}

}
