package com.TCS_POC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TCS_POC.Model.User;
import com.TCS_POC.repository.UserRepo;

@Service
public class LoginServices {
	@Autowired
	UserRepo userRepo;
	
	public List<User> getUserDetails() {
		return userRepo.findAll();
	}
	
	public User LoginUser(String email,String password)throws Exception {
		return  userRepo.findByLogin(email, password).orElseThrow(()->new Exception("User Not found.."));
	}
	public User RegisterUser(User user) {
		userRepo.save(user);
		return user;
	}
}
