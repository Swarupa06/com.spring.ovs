package com.spring.ovs.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.User;
import com.spring.ovs.repository.UserRepository;


@Service
public class UserService 
{
	@Autowired
	UserRepository urRepo;
	
	 public List<User> getAllUsers()
	 {
		 List<User> user = new ArrayList<User>();
		System.out.println("Users...");
	 urRepo.findAll().forEach(user1 -> user.add(user1));
	 return user;
	 }
	 public User findByUserId(int userId) 
	 {
		 return urRepo.findById(userId).get();
	 }
	 
	 public int registerUser(User user)
	 {
	       urRepo.save(user);
		return user.getUserId();
	 }
	 
	 
	 public int deleteUser(int userId)
	 {
		  urRepo.deleteById(userId);
		return userId;
	 }
	 public int updateUser(User user) {
	       	
	       	 urRepo.save(user);
	       	return user.getUserId();
	 	}
	
}




