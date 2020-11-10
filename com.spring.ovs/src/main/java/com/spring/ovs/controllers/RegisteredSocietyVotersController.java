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

import com.spring.ovs.dtos.RegisteredSocietyVoters;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.RegisteredSocietyVotersService;


@RestController
public class RegisteredSocietyVotersController
{
 
   Logger log = LoggerFactory.getLogger(RegisteredSocietyVotersController.class);
	
	@Autowired
	private RegisteredSocietyVotersService rsvService;
	
	
	@PostMapping("/reg_society")
    public @ResponseBody int voterRegistration(@RequestBody RegisteredSocietyVoters voter) 
    {
	     return rsvService.voterRegistration(voter);
    }
    
    @PutMapping("/reg_society/{voterId}")
    public @ResponseBody RegisteredSocietyVoters updateRegisteredSocietyVotersDetails(@PathVariable("voterId") int voterId,RegisteredSocietyVoters voter) throws VoterNotFoundException 
    {
    	
    	return rsvService.updateRegisteredSocietyVotersDetails(voterId, voter);
    }
    
    @DeleteMapping("/reg_society/{voterId}")
    public @ResponseBody int deleteRegisteredSocietyVoter(@PathVariable("voterId") int voterId) throws VoterNotFoundException 
    {
	  return rsvService.deleteRegisteredSocietyVoter(voterId);
    }
    
    @GetMapping("/reg_society" )
    public @ResponseBody List<RegisteredSocietyVoters> viewRegisteredVoterList() 
    { 
    	return rsvService.viewRegisteredVoterList();
    }
    
    @GetMapping("/reg_society/{voterId}")
    public @ResponseBody RegisteredSocietyVoters searchByVoterID(@PathVariable("voterId") int voterId) throws VoterNotFoundException 
    {
    	
	   return rsvService.searchByVoterID(voterId);
	  
    }
    
    

}


