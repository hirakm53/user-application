package com.hirak.user.userapplication.service;

import com.hirak.user.userapplication.model.User;

public interface UserService {
	
	public User getUser(String mobileNo);
	
	public String saveUser(User user);

}
