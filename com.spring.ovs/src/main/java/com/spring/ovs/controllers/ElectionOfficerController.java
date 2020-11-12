package com.ovs.spring.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ovs.spring.demo.dtos.ElectionOfficer;
import com.ovs.spring.demo.exceptions.DuplicateRecordException;
import com.ovs.spring.demo.exceptions.ElectionOfficerNotFoundException;
import com.ovs.spring.demo.service.ElectionOfficerService;


//connect from postman as http://localhost:8080/officer/
@RestController
@RequestMapping("/officer")
public class ElectionOfficerController
{
	/*A Logger object is used to log messages for a specific system or application component.
	 *Loggers are normally named,using a hierarchical dot-separated namespace.
     */
	
    Logger log = LoggerFactory.getLogger(ElectionOfficerController.class);
	
	@Autowired  //enables you to inject the object dependency implicitly. It internally uses setter injection.
	
	private ElectionOfficerService elService;
	

    @GetMapping(value= {"/"})
    public @ResponseBody List<ElectionOfficer> getAllElectionOfficers() 
    { 
    	List<ElectionOfficer> officer=elService.getAllElectionOfficers();
    	return officer;
    }
    
    @GetMapping("/{officerId}")
    public ResponseEntity<ElectionOfficer> viewElectionOfficerById(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
    {
       if(elService.viewElectionOfficerById(officerId)==null)
       {
    	   throw new ElectionOfficerNotFoundException("Election Officer not found with the Id:"+officerId); 
       }
       else
       {	   
	     return new ResponseEntity<ElectionOfficer>(elService.viewElectionOfficerById(officerId),HttpStatus.OK);
       }
    }
    
    @PostMapping("/")
    public ResponseEntity<ElectionOfficer> addElectionOfficerDetails(@RequestBody @Valid ElectionOfficer officer) throws DuplicateRecordException 
    {
	    int officerId=elService.addElectionOfficerDetails(officer);
    	if(officerId!=0)
    	{
    		return new ResponseEntity<ElectionOfficer>(elService.viewElectionOfficerById(officerId),HttpStatus.OK);
    	}
    	else
    	{
    		throw new DuplicateRecordException("Id already exists");
    	}
    }
    
    @PutMapping("/{officerId}")
    public ResponseEntity<ElectionOfficer> updateElectionOfficerDetails(@RequestBody @Valid ElectionOfficer officer ) throws ElectionOfficerNotFoundException 
    {
    	int officerId=elService.updateElectionOfficerDetails(officer);
		if(officerId!=0)
    	{
			return new ResponseEntity<ElectionOfficer>(elService.viewElectionOfficerById(officerId),HttpStatus.OK);
    	}
    	else
    	{	
    		throw new ElectionOfficerNotFoundException("Officer not found");
        }
    }    
	@DeleteMapping("/{officerId}")
    public ResponseEntity<ElectionOfficer> deleteElectionOfficer(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
    {
    	officerId=elService.deleteElectionOfficer(officerId);
    	if(officerId!=0)
    	{
    		return new ResponseEntity<ElectionOfficer>(elService.viewElectionOfficerById(officerId),HttpStatus.OK);
    	}
    	else
    	{
    		throw new ElectionOfficerNotFoundException("Election Officer not found with the Id:"+officerId); 
    	}
	    
    }
    
    

}
