package com.spring.ovs.dtos;



import javax.persistence.CascadeType;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.spring.ovs.dtos.RegisteredSocietyVoters;

@Entity
@Table(name="candidate")


public class NominatedCandidates {
	@Id
	@GeneratedValue
	@Column(name="candidateId")
	private int candidateId;
	private String nominationFormNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="societyId")
	private RegisteredSocietyVoters society_Voter;
	
	
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getNominationFormNo() {
		return nominationFormNo;
	}
	public void setNominationFormNo(String nominationFormNo) {
		this.nominationFormNo = nominationFormNo;
	}
	public RegisteredSocietyVoters getSociety_Voter() {
		return society_Voter;
	}
	public void setSociety_Voter(RegisteredSocietyVoters society_Voter) {
		this.society_Voter = society_Voter;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NominatedCandidates{");
		sb.append("candidateId:").append(candidateId).append(",");
		sb.append("nominationFormNo:").append(nominationFormNo).append(",");
		sb.append("society_Voter:").append(society_Voter).append(",");
		
		sb.append("}");
		
		return sb.toString();
	
}
}