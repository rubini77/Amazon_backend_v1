package com.amazon.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.demo.exception.EmailAlreadyExistsException;
import com.amazon.demo.model.User;
import com.amazon.demo.service.UserService;
import com.amazon.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userrepo;
	
	@Override
	public boolean saveUserInfo(User user) {
	    if(userrepo.existsByEmail(user.getEmail())) {
			return false;
		}
		else if(userrepo.existsByName(user.getName())) {
			return false;
		}
		
		User savedEntity = userrepo.save(user);
		return true;
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
