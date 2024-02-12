package com.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.entity.User;




@Service
public interface UserService {
	
	
	User SaveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userid);	

}
