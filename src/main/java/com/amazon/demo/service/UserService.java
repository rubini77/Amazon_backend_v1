package com.amazon.demo.service;

import com.amazon.demo.model.User;

public interface UserService {
	User saveUserInfo(User user);
	boolean checkUser(String email,String password);

}
