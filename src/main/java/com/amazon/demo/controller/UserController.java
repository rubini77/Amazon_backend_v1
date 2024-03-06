package com.amazon.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.demo.model.User;
import com.amazon.demo.service.UserService;
import com.amazon.demo.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice; //dependency injection
	
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUserInfo(@RequestBody User user){
	    	userservice.saveUserInfo(user);
	    	return ResponseEntity.status(HttpStatus.OK).body(user);
	    }
	
	@PostMapping("/checkuser")
	public ResponseEntity<Boolean> checkUser(@RequestBody UserDto userdto){
		System.out.println(userdto.getEmail() + " " + userdto.getPassword());
		
		boolean success=userservice.checkUser(userdto.getEmail(),userdto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(success);
//		ResponseEntity<?> userexists =userservice.checkUser(user);
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userexists);
	}

}
