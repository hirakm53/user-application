package com.hirak.user.userapplication.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hirak.user.userapplication.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Map<String, String> userList = new HashMap<>();

	@Override
	public User getUser(String mobileNo) {
		Map<String, String> userList = userList();
		User user = new User();
		String name = userList.get(mobileNo);
		user.setName(name);
		user.setMobileNo(mobileNo);
		return user;
	}

	@Override
	public String saveUser(User user) {
		userList.put(user.getMobileNo(), user.getName());
		return "Created new entry successfully!";
	}
	
	private Map<String, String> userList() {		
		userList.put("9876543210", "ABC");
		userList.put("1234567890", "XYZ");
		return userList;
	}

}
