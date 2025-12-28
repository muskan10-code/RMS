package com.manav.ncu.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.manav.ncu.dao.UserDAO;
import com.manav.ncu.models.Rights;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;
import com.manav.ncu.models.UserRole;

import ch.qos.logback.core.encoder.Encoder;

@Component
public class UserHelper {
@Autowired
UserDAO userDao;
@Autowired
private PasswordEncoder encoder;
	public String addUser(User user) {
		// TODO Auto-generated method stub
		//user.setPassword(encoder.encode(user.getPassword()));
		return userDao.addUser(user)>0?"UserAddedSuccessFully":"Error in Add";
	}
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		return userDao.addRole(role)>0?"RoleAdded":"error";
	}
	public String findRole(String username) {
		// TODO Auto-generated method stub
		return userDao.findRole(username);
	}
	public List<Rights> findRight(String username) {
		// TODO Auto-generated method stub
		return userDao.findRight(username);
	}
	public List<UserRole> findAllEmployee() {
		// TODO Auto-generated method stub
		return userDao.findAllEmployee();
	}
	public List<UserRole> findEmpType(String userType) {
		// TODO Auto-generated method stub
		return userDao.findEmp(userType);
	}
	public UserRole profile(String username) {
		// TODO Auto-generated method stub
		return userDao.profile(username);
	}

}
