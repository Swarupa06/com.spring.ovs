package com.spring.ovs.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class User{
	


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="password")
 	private String password;
 	
	
 	@Column(name="firstName")
 	private String firstName;
 	
 	@Column(name="lastName")
 	private String lastName;
 	
 	@Column(name="email")
 	private String email;
 	
 	@Column(name="contactno")
 	private String contactno;
 	
 	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public User() {
		   super();
	}
	public User(int userId,String password,String firstName,String lastName,String email,String contactno) {
		super();
		this.userId=userId;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.contactno=contactno;
	}
	
	public User(String password,String firstName,String lastName,String email,String contactno) {
		super();
	
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.contactno=contactno;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("User{");
		sb.append("userId:").append(userId).append(",");
		sb.append("password:").append(password).append(",");
		sb.append("firstName:").append(firstName).append(",");
		sb.append("lastName:").append(lastName).append(",");
		sb.append("email:").append(email).append(",");
		sb.append("contactno:").append(contactno).append(",");
		sb.append("}");
		
		return sb.toString();
		
	}
	
	
}
