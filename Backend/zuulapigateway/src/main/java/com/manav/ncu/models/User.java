package com.manav.ncu.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_mst")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int uid;
private String name;
private String username;
private String password;
private String phoneNo;
private int userType;
public User() {}
public User(int uid, String name, String username, String password, String phoneNo, int userType) {
	super();
	this.uid = uid;
	this.name = name;
	this.username = username;
	this.password = password;
	this.phoneNo = phoneNo;
	this.userType = userType;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public int getUserType() {
	return userType;
}
public void setUserType(int userType) {
	this.userType = userType;
}
}

