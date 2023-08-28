package com.yesgaori.spring.ex.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.ex.jsp.domain.User;
import com.yesgaori.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String name, String birthday, String email) {
		
		int count = userRepository.insertUser(name, birthday, email);
		
		return count;
	}
	
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
}
