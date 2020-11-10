package com.spring.ovs.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ovs.dtos.User;
import com.spring.ovs.exceptions.UserNotFoundException;
import com.spring.ovs.service.UserService;



@RestController

public class UserController
{
 
   Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService urService;
	
	
	 @PostMapping("/userdetails")
	    public @ResponseBody User registerUser(@RequestBody User user) 
	    {
		     return urService.registerUser(user);
	    }
	 @PutMapping("/userdetails/{userId}")
	    public @ResponseBody User updateUser(@PathVariable int userId, @RequestBody User user) throws UserNotFoundException 
	    {
	    	
	    	return urService.updateUser(userId, user);
	    }

    @GetMapping("/userdetails" )
    public @ResponseBody List<User> getAllUsers() 
    { 
    	return urService.getAllUsers();
    }
    
    @GetMapping("/userdetails/{userId}")
    public @ResponseBody User  findByUserId(@PathVariable("userId") int userId) throws UserNotFoundException 
    {
	
	 return urService. findByUserId(userId);
	  
	  
    }
    
  
    @DeleteMapping("/userdetails/{userId}")
    public @ResponseBody int deleteUser(@PathVariable int userId) throws UserNotFoundException 
    {
	  return urService.deleteUser(userId);
    }
    
    

}



