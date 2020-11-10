package com.spring.ovs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;


public interface ElectionResultRepository extends JpaRepository<ElectionResult, Integer> {

	
	@Query("select er.totalPollingPercentage from results er")
	public double viewVotingPercentage();
	
	@Query("select er.candidateVotesPercentage from results er where er.candidateId=24")
	public double viewCandidateVotingPercent(int candidateId);

	@Query("select er.coop_SocietyName,er.totalSocietyVotes,er.totalCandidateVotes,er.totalPolledVotes,er.candidateVotesPercentage,er.totalPollingPercentage,er.result from results er")
	public void displayVotingStatistics();
	
	@Query("select MAX(er.candidateVotesPercentage) from results er")
	public  NominatedCandidates viewHighestVotingPercentCandidate();
	
	@Query("select MIN(er.candidateVotesPercentage) from results er")
	public  NominatedCandidates viewLowestVotingPercentCandidate();
	
	@Query("select COUNT(er.id) from results er GROUP BY er.id HAVING COUNT(er.id)>1")
	public int viewInvalidVotes();
	
	@Query("select COUNT(er.candidateId) from results er GROUP BY er.candidateId HAVING COUNT(er.candidateId)>1")
	public  List<NominatedCandidates> candidatewiseInvalidVotesList();
	
	@Query("select er.result from results er")
	public void displayPollingResult();

}

