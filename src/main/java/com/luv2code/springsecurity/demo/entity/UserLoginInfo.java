package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserLoginInfo {

	@Id
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@Column(name="enabled")
	private short enabled;
	
	public UserLoginInfo() {} 
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public short getEnabled() {
		return enabled;
	}
	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserLoginInfo [userName=" + userName + ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	
}
