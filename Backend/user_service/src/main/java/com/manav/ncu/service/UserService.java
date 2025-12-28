package com.manav.ncu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manav.ncu.helper.UserHelper;
import com.manav.ncu.models.Rights;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;
import com.manav.ncu.models.UserRole;

@Service
public class UserService {
@Autowired
UserHelper userHelper;
	public String addUser(User user) {
		// TODO Auto-generated method stub
		String password=user.getPassword();
		String hashPassword=passwordEncoder(password);
		user.setPassword(hashPassword);
		return userHelper.addUser(user);
	}
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		return userHelper.addRole(role);
	}
	public String findRole(String username) {
		// TODO Auto-generated method stub
		return userHelper.findRole(username);
	}
	public List<Rights> findRight(String username) {
		// TODO Auto-generated method stub
		return userHelper.findRight(username);
	}
	public List<UserRole> findAllEmployee() {
		// TODO Auto-generated method stub
		return userHelper.findAllEmployee();
	}
	public List<UserRole> findEmpType(String userType) {
		// TODO Auto-generated method stub
		return userHelper.findEmpType(userType);
	}
	
	public String passwordEncoder(String password) {
	   BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	   System.out.println("Inside the password encoder and the password is "+password);
	   return encoder.encode(password);
	}
	public UserRole profile(String username) {
		// TODO Auto-generated method stub
		return userHelper.profile(username);
	}

}
