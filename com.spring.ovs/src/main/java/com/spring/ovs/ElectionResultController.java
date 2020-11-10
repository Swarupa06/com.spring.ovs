package com.spring.ovs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.service.ElectionResultService;


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
	    public @ResponseBody int addElectionResult(@RequestBody ElectionResult result) 
	    {
		     return erService.addElectionResult(result);
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
	
	@GetMapping("/")
	public @ResponseBody  void displayVotingStatistics()
	{
		erService.displayVotingStatistics();
	}
	
	@GetMapping("/{viewHighestVotingPercentCandidate}")
	public @ResponseBody  NominatedCandidates viewHighestVotingPercentCandidate()
	{
		return erService.viewHighestVotingPercentCandidate();
	}
	
	@GetMapping("/{viewLowestVotingPercentCandidate}")
	public @ResponseBody  NominatedCandidates viewLowestVotingPercentCandidate()
	{
		return erService.viewLowestVotingPercentCandidate();
	}
	
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
