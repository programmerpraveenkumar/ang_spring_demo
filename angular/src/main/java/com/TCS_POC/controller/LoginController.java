package com.TCS_POC.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TCS_POC.Model.User;
import com.TCS_POC.services.LoginServices;

@RestController
@RequestMapping("api")
public class LoginController {

	@Autowired
	LoginServices loginservice;
	
	@RequestMapping("login")
	public  ResponseEntity<?>  loginApi(@RequestBody HashMap<String,String> request) {
		try {
			User u = loginservice.LoginUser(request.get("email"),request.get("password"));
			return ResponseEntity.ok(u);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Response(e.getMessage()));
		}
	}
	
	@RequestMapping("register")
	public  ResponseEntity<?>  registerApi(@RequestBody HashMap<String,String> request) {
		try {
			User user = new User();
			user.setEmail(request.get("email"));
			user.setName(request.get("name"));
			user.setPassword(request.get("pass"));
			User u = loginservice.RegisterUser(user);
			return ResponseEntity.ok(u);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Response(e.getMessage()));
		}
	}
}
