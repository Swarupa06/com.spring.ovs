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

import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.exceptions.NominatedCandidateNotFoundException;
import com.spring.ovs.service.NominatedCandidatesService;
@RestController
public class NominatedConditesController {
Logger log = LoggerFactory.getLogger(NominatedConditesController.class);
	
	@Autowired
	private NominatedCandidatesService ncService;
	

    @GetMapping("/candidate" )
    public @ResponseBody List<NominatedCandidates> getAllNominatedCandidates() 
    { 
    	return ncService.getAllNominatedCandidates();
    }
    @GetMapping("/candidate/{candidateId}")
   
    public @ResponseBody NominatedCandidates viewNominatedCandidatesById(@PathVariable("candidateId") int candidateId) throws  NominatedCandidateNotFoundException
    {
	
	    return ncService.viewNominatedCandidatesById(candidateId);
	 
	  
    } 
    @PostMapping("/candidate")
    public @ResponseBody NominatedCandidates addNominatedCandidate(@RequestBody NominatedCandidates candidate) 
    {
	     return ncService.addNominatedCandidate(candidate);
    }
    @PutMapping("/candidate/{candidateId}")
    public @ResponseBody NominatedCandidates updateNominatedCandidateDetails(@PathVariable("candidateId") int candidateId,@RequestBody NominatedCandidates candidate ) throws NominatedCandidateNotFoundException
    {
    	
    	return ncService.updateNominatedCandidateDetails(candidateId,candidate);
    }
    @DeleteMapping("/candidate/{candidateId}")
    public @ResponseBody int deleteNominatedCandididates(@PathVariable("candidateId") int candidateId) throws  NominatedCandidateNotFoundException
    {
	  return ncService.deleteNominatedCandididates(candidateId);
    }
    
}
