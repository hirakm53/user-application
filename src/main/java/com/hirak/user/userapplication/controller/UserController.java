package com.hirak.user.userapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hirak.user.userapplication.model.User;
import com.hirak.user.userapplication.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUser(@RequestParam("mobileNo") String mobileNo) {
		User user = null;
		if(!mobileNo.isEmpty()) {
			user = userService.getUser(mobileNo);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}		
		return new ResponseEntity<String>("Invalid input", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		String msg = null;
		if(user!=null) {
			msg = userService.saveUser(user);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Invalid request!", HttpStatus.BAD_REQUEST);
	}

}
