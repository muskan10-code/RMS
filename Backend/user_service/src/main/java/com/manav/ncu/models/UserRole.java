package com.manav.ncu.models;

public class UserRole {
private String name;
private String username;
private String role;
private String phoneNo;
private int uId;
public UserRole(String name, String username, String role, String phoneNo, int uId) {
	super();
	this.name = name;
	this.username = username;
	this.role = role;
	this.phoneNo = phoneNo;
	uId = uId;
}

public int getuId() {
	return uId;
}

public void setuId(int uId) {
	this.uId = uId;
}

public UserRole() {}
public String getName() {
	return name;
}
@Override
public String toString() {
	return "UserRole [name=" + name + ", username=" + username + ", role=" + role + ", phoneNo=" + phoneNo + "]";
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
}
