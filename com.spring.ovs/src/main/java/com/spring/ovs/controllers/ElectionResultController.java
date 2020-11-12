package com.spring.ovs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovs.spring.demo.dtos.ElectionResult;
import com.ovs.spring.demo.dtos.NominatedCandidates;
import com.ovs.spring.demo.exceptions.DuplicateRecordException;
import com.ovs.spring.demo.service.ElectionResultService;



@RestController
@RequestMapping("/results")
public class ElectionResultController
{
   
Logger log = LoggerFactory.getLogger(ElectionResultController.class);
	
	@Autowired
	private ElectionResultService erService;
	
	 @GetMapping("/" )
	    public @ResponseBody List<ElectionResult> viewElectionResultList() 
	    { 
	    	return erService.viewElectionResultList();
	    }
	 
	 @PostMapping("/")
	    public ResponseEntity<ElectionResult> addElectionResult(@RequestBody ElectionResult result) throws DuplicateRecordException 
	    {
		    int id=erService.addElectionResult(result);
		    if(id!=0)
		    {
		    	return new ResponseEntity<ElectionResult>(erService.viewCandidatewiseResult(id),HttpStatus.OK);
		    }
		    else
		    {
		    	throw new DuplicateRecordException("Result with this Id already exists");
		    }
		    
	    }
	 
	@GetMapping("/{id}")
	  public @ResponseBody ElectionResult viewCandidatewiseResult(@PathVariable("id") int id)
	  {
		return erService.viewCandidatewiseResult(id);
		
	  }
	
	@GetMapping("/{totalPollingPercentage}")
	  public @ResponseBody double viewVotingPercentage()
	  {
		return erService.viewVotingPercentage();
		
	  }
	
	@GetMapping("/{viewCandidateVotingPercent}")
	public @ResponseBody  double viewCandidateVotingPercent(int candidateId)
	{
		return erService.viewCandidateVotingPercent(candidateId);
	}
	
	@GetMapping("/displayVotingStatistics")
	public @ResponseBody  void displayVotingStatistics()
	{
		erService.displayVotingStatistics();
	}
	
	@GetMapping("/viewHighestVotingPercentCandidate/")
	public @ResponseBody  NominatedCandidates viewHighestOrLowestVotingPercentCandidate(boolean H)
	{
		if (H==true)
		{	
		 return erService.viewHighestVotingPercentCandidate();
	    }
		else
		{
			return erService.viewLowestVotingPercentCandidate();
		}
	}
	
	/*@GetMapping("/{viewLowestVotingPercentCandidate}")
	public @ResponseBody  NominatedCandidates viewLowestVotingPercentCandidate()
	{
		return erService.viewLowestVotingPercentCandidate();
	}*/
	
	@GetMapping("/{viewInvalidVotes}")
	public @ResponseBody int viewInvalidVotes()
	{
		return erService.viewInvalidVotes();
	}
	
	@GetMapping("/{candidatewiseInvalidVotesList}")
	public @ResponseBody List<NominatedCandidates> candidatewiseInvalidVotesList()
	{
		return erService.candidatewiseInvalidVotesList();
	}
	
	@GetMapping("/{result}")
	public @ResponseBody void displayPollingResult()
	{
		erService.displayPollingResult();
	}
	
		
}
