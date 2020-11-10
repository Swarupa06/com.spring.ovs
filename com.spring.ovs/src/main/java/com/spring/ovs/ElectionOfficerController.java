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

import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.exceptions.ElectionOfficerNotFoundException;
import com.spring.ovs.service.ElectionOfficerService;


@RestController

public class ElectionOfficerController
{
 
   Logger log = LoggerFactory.getLogger(ElectionOfficerController.class);
	
	@Autowired
	private ElectionOfficerService elService;
	

    @GetMapping("/officer" )
    public @ResponseBody List<ElectionOfficer> getAllElectionOfficers() 
    { 
    	return elService.getAllElectionOfficers();
    }
    
    @GetMapping("/officer/{officerId}")
    public @ResponseBody ElectionOfficer viewElectionOfficerById(@PathVariable("officerId") int officerId) throws ElectionOfficerNotFoundException 
    {
    	
	   return elService.viewElectionOfficerById(officerId);
	  
    }
    
    @PostMapping("/officer")
    public @ResponseBody ElectionOfficer addElectionOfficerDetails(@RequestBody ElectionOfficer officer) 
    {
	     return elService.addElectionOfficerDetails(officer);
    }
    
    @PutMapping("/officer/{officerId}")
    public @ResponseBody ElectionOfficer updateElectionOfficerDetails(@PathVariable int officerId,@RequestBody ElectionOfficer officer ) throws ElectionOfficerNotFoundException 
    {
    	
    	return elService.updateElectionOfficerDetails(officerId,officer);
    }
    
    @DeleteMapping("/officer/{officerId}")
    public @ResponseBody int deleteElectionOfficer(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
    {
	  return elService.deleteElectionOfficer(officerId);
    }
    
    

}
