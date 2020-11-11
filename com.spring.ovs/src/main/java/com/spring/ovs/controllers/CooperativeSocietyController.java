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

import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.exceptions.SocietyNotFoundException;
import com.spring.ovs.service.CooperativeSocietyService;



@RestController

public class CooperativeSocietyController
{
 
   Logger log = LoggerFactory.getLogger(CooperativeSocietyController.class);
	
	@Autowired
	private CooperativeSocietyService csService;
	
	
	 @PostMapping("/society")
	    public @ResponseBody CooperativeSociety addSocietyDetails(@RequestBody CooperativeSociety  society) 
	    {
		     return csService.addSocietyDetails(society);
	    }
	 @PutMapping("/society/{societyId}")
	    public @ResponseBody CooperativeSociety updateSocietyDetails(@PathVariable CooperativeSociety society ) throws SocietyNotFoundException 
	    {
	    	
	    	return csService.updateSocietyDetails(society);
	    }
	 
	 @DeleteMapping("/society/{societyId}")
	    public @ResponseBody int deleteSociety(@PathVariable int societyId) throws SocietyNotFoundException 
	    {
		  return csService.deleteSociety(societyId);
	    }

   @GetMapping("/society" )
    public @ResponseBody List< CooperativeSociety > getAllCooperativeSocieties() //viewSocietiesList()
    { 
    	return csService. getAllCooperativeSocieties();//viewSocietiesList();
    }
    
    @GetMapping("/society/{societyId}")
    public @ResponseBody CooperativeSociety  viewSocietyById(@PathVariable("societyId") int societyId) throws SocietyNotFoundException 
    {
	
	return csService. viewSocietyById(societyId);
	 
	  
    }
    
}
