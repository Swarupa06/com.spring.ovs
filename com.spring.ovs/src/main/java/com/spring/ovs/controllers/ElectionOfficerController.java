package com.spring.ovs.controllers;

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
import com.ovs.spring.demo.exceptions.ElectionOfficerNotFoundException;
import com.ovs.spring.demo.service.ElectionOfficerService;


//connect from postman as http://localhost:8080/officer/
@Controller
@RequestMapping("/officer")
public class ElectionOfficerController
{
      
	  /*A Logger object is used to log messages for a specific system or application component.
	   *Loggers are normally named,using a hierarchical dot-separated namespace.
       */
	
	  Logger log = LoggerFactory.getLogger(ElectionOfficerController.class);
	
	  
	  @Autowired    //enables you to inject the object dependency implicitly. It internally uses setter injection.
	  private ElectionOfficerService eoService;
	
	
     /*
        * @Author      : Swarupa
        * 
        * @Method      : getAllElectionOfficers() 
        * 
        * @Return type : ElectionOfficer
        * 
        * @Description : This method is used to get all the existing Election officers Details.
     */

	
      @GetMapping(value = {"/" })
      public @ResponseBody List<ElectionOfficer> getAllElectionOfficers() 
      { 
	
	    List<ElectionOfficer> officer = eoService.getAllElectionOfficers();

	    return officer;
      }
    
    
     /*
        * @Author      : Swarupa
        * 
        * @Method      : viewElectionOfficerById()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : ElectionOfficer
        * 
        * @Description : This method is used to view the particular Election officer details with the entered ID.
     */

    
     @GetMapping("/{officerId}")
     public @ResponseBody  ElectionOfficer viewElectionOfficerById(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
     {
	
	    return eoService.viewElectionOfficerById(officerId);
     }
     
     
     /*
        * @Author      : Swarupa
        * 
        * @Method      : addElectionOfficerDetails()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : Integer
        * 
        * @Description : This is the method for adding Election officer details.
      */


    
     @PostMapping("/")
     public @ResponseBody int addElectionOfficerDetails(@RequestBody @Valid ElectionOfficer officer) 
     {
	   return eoService.addElectionOfficerDetails(officer);
     }
     
     
     /*
        * @Author      : Swarupa
        * 
        * @Method      : updateElectionOfficerDetails()
        * 
        * @Parameter   : officerId,officer
        * 
        * @Return type : Integer
        *   
        * @Description : This is the method for Updating the existing Election officer details. 
      */
    
     
       @PutMapping("/{officerId}")
       public @ResponseBody ElectionOfficer updateElectionOfficerDetails(@PathVariable int officerId,@RequestBody @Valid ElectionOfficer officer) throws ElectionOfficerNotFoundException 
       {
	
	      return eoService.updateElectionOfficerDetails(officerId,officer);
       }
       
      /*
        * @Author      : Swarupa
        * 
        * @Method      : deleteElectionOfficer()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : Integer
        * 
        * @Description : This is the method for deleting the existing Election officer details.
      */

       @DeleteMapping("/{officerId}")
       public @ResponseBody int deleteElectionOfficer(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
      {
	    return eoService.deleteElectionOfficer(officerId);
      }

}
