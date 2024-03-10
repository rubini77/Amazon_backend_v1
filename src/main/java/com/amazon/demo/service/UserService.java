package com.amazon.demo.service;

import com.amazon.demo.model.User;

public interface UserService {
	boolean saveUserInfo(User user);
	boolean checkUser(String email,String password);

}
