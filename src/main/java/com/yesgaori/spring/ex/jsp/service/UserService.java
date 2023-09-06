package com.yesgaori.spring.ex.jsp.service;

import java.util.List;

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
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public List<User> getUserList() {
		
		List<User> list = userRepository.selectUserList(); 
		
		return list;
	}
	
	// 중복된 email 인지 확인하는 기능
	public boolean isDuplicateEmail(String email) {
		
		int count = userRepository.selectCountEmail(email);
		
		if(count == 0) { // 중복되지 않음
			return false;
		} else { // 중복죔
			return true;
		}
		
	}
	
	
	
}
