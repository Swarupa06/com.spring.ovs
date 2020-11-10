package com.spring.ovs.dtos;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="society")

public class CooperativeSociety {
	@Id
	@GeneratedValue
	@Column(name="societyId")
private int societyId;
	
	@Column(name="society_Name")
private String societyName;
	
	@Column(name="society_Hos")
private String headOfSociety;
	
	@Column(name="society_village")
private String village;
	
	@Column(name="society_mandal")
private String mandal;
	
	@Column(name="society_district")
private String district;
	
	@Column(name="society_pincode")
private String pincode;

public CooperativeSociety() {
	super();
	// TODO Auto-generated constructor stub
}
public CooperativeSociety(int societyId, String societyName, String headOfSociety, String village, String mandal,
		String district, String pincode) {
	super();
	this.societyId = societyId;
	this.societyName = societyName;
	this.headOfSociety = headOfSociety;
	this.village = village;
	this.mandal = mandal;
	this.district = district;
	this.pincode = pincode;
}
public int getSocietyId() {
	return societyId;
}
public void setSocietyId(int societyId) {
	this.societyId = societyId;
}
public String getSocietyName() {
	return societyName;
}
public void setSocietyName(String societyName) {
	this.societyName = societyName;
}
public String getHeadOfSociety() {
	return headOfSociety;
}
public void setHeadOfSociety(String headOfSociety) {
	this.headOfSociety = headOfSociety;
}
public String getVillage() {
	return village;
}
public void setVillage(String village) {
	this.village = village;
}
public String getMandal() {
	return mandal;
}
public void setMandal(String mandal) {
	this.mandal = mandal;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "CoperativeSociety [societyId=" + societyId + ", societyName=" + societyName + ", headOfSociety="
			+ headOfSociety + ", village=" + village + ", mandal=" + mandal + ", district=" + district + ", pincode="
			+ pincode + "]";
}

}