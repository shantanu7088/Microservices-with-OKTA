package com.userservice.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.repo.UserRepository;
import com.userservice.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userrepo;	
	

	@Override
	public User SaveUser(User user) {
		String randomuserid=UUID.randomUUID().toString();
		user.setUserid(randomuserid);
		return userrepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userrepo.findAll();
	}

	@Override
	public User getUser(String userid) {
		
		return userrepo.findById(userid).orElseThrow(()->new ResourceNotFoundException());
	}

}