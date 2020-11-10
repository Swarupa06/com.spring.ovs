package com.spring.ovs.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.repository.ElectionResultRepository;

@Service
public class ElectionResultService {
    
	@Autowired
	ElectionResultRepository erRepo;
	
	public int addElectionResult(ElectionResult result)
	{
		erRepo.save(result);
		return result.getId();
	}
	
	public List<ElectionResult> viewElectionResultList()
	{
		List<ElectionResult> result = new ArrayList<ElectionResult>(); 
		System.out.println("Election Results...");
		erRepo.findAll().forEach(result1 -> result.add(result1));
     	return result;	
	}
	
	public ElectionResult viewCandidatewiseResult(int id)
	{
		
		return erRepo.findById(id).get();	
		
	}
	
	public double viewVotingPercentage()
	{
		
		return erRepo.viewVotingPercentage();	
		
	}
	
	public double viewCandidateVotingPercent(int candidateId)
	{
		
		return erRepo.viewCandidateVotingPercent(candidateId);	
		
	}
	
	public void displayVotingStatistics()
	{
		
		erRepo.displayVotingStatistics();
		
	}
	
	public  NominatedCandidates viewHighestVotingPercentCandidate()
	{
		
		return erRepo.viewHighestVotingPercentCandidate();
		
	}
	
	public  NominatedCandidates viewLowestVotingPercentCandidate() 
	{
		
		return erRepo.viewLowestVotingPercentCandidate();
		
	}
	
	public int viewInvalidVotes()
	{
		
		return erRepo.viewInvalidVotes();
		
	}
	
	public  List<NominatedCandidates> candidatewiseInvalidVotesList()
	{
		
		return erRepo.candidatewiseInvalidVotesList();
		
	}
	
	public void displayPollingResult()
	{
		
		erRepo.displayPollingResult();
		
	}
	
}
