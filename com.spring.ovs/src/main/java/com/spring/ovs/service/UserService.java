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
	 
	 public User registerUser(User user)
	 {
	     return  urRepo.save(user);

	 }
	 
	 
	 public int deleteUser(int userId)
	 {
		  urRepo.deleteById(userId);
		return userId;
	 }
	 public User updateUser(int userId,User user) {
	       	
	      return urRepo.save(user);
	       	
	 	}
	
}




