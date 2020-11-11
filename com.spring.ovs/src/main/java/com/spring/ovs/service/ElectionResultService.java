package com.ovs.spring.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	
	public  NominatedCandidates viewHighestOrLowestVotingPercentCandidate(boolean H)
	{
		
		System.out.println("Enter the character H to view the Highest voting percentage candidate or It will display the Lowest voting percentage candidate");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.nextBoolean();
		if (H==true)
		{	
		 return erRepo.viewHighestVotingPercentCandidate();
	    }
		else
		{
			return erRepo.viewLowestVotingPercentCandidate();
		}
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
