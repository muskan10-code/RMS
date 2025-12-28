package com.manav.ncu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manav.ncu.dao.Dao;
import com.manav.ncu.dao.RoleDao;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;


@Service
public class UserDetailService implements UserDetailsService{
@Autowired
private Dao dao;
@Autowired
private RoleDao roleDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> users=dao.findByUsername(username);
		Role role=roleDao.findRole(users.get(0).getUserType());
		if(users.size()==0) {
			throw new UsernameNotFoundException("Invalid cred");
		}
		UserDetail userDetail=new UserDetail(users.get(0),role);
		System.out.println("inside userdetail   .... "+users.get(0));
		return userDetail;
	}

}
