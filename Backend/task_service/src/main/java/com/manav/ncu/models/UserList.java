package com.manav.ncu.models;

import java.util.ArrayList;
import java.util.List;

public class UserList {
private List<UserRole> user;
public UserList() {
	user=new ArrayList<>();
}
public List<UserRole> getUser() {
	return user;
}
@Override
public String toString() {
	return "UserList [user=" + user + "]";
}
public void setUser(List<UserRole> user) {
	this.user = user;
}
}
