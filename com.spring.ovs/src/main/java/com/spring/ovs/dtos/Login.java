package com.spring.ovs.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Loginname")
	private String loginName;
	
	@Column(name="Password")
	private String loginPassword;
	
	public Login() {
		super();
	}

	public Login(String loginName, String loginPassword) {
		super();
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}

	public Login(int id, String loginName, String loginPassword) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", loginName=" + loginName + ", loginPassword=" + loginPassword + "]";
	}
	

}
