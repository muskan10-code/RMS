package com.manav.ncu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manav.ncu.models.Rights;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;
import com.manav.ncu.models.UserRole;

@Repository
@Transactional
public class UserDAO {
@PersistenceContext
private EntityManager entityManager;
	public int addUser(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		return user.getUid();
	}
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		 entityManager.persist(role);
		return role.getRoleId();
	}
	public String findRole(String username) {
		// TODO Auto-generated method stub
		List<User> list=entityManager.createQuery("select u from User u where u.username=:param", User.class).setParameter("param",username).getResultList();
		int userType=list.get(0).getUserType();
		Role role=entityManager.createQuery("select r from Role r where r.roleId=:param1",Role.class).setParameter("param1", userType).getSingleResult();
		return role.getRoleName();
	}
	public List<Rights> findRight(String username) {
		// TODO Auto-generated method stub
		List<User> list=entityManager.createQuery("select u from User u where u.username=:param", User.class).setParameter("param",username).getResultList();
		int userType=list.get(0).getUserType();
		List<Rights> rightList=entityManager.createNativeQuery("select right_mst.right_id,right_name,right_url from right_mst,role_right_mapping where role_right_mapping.right_id=right_mst.right_id and role_right_mapping.role_id=:param1",Rights.class).setParameter("param1", userType).getResultList();
		return rightList;
	}
	public List<UserRole> findAllEmployee() {
		// TODO Auto-generated method stub
		List<User> list=entityManager.createQuery("select u from User u where u.userType=1 or u.userType=2 or u.userType=3", User.class).getResultList();
		List<Role> roleList=entityManager.createQuery("select r from Role r").getResultList();
		List<UserRole> resultList=new ArrayList<>();
		System.out.println("Inside dao .........");
		System.out.println(list);
		System.out.println(roleList);
		for(int i=0;i<list.size();i++) {
			UserRole userRole=new UserRole();
			userRole.setName(list.get(i).getName());
			userRole.setPhoneNo(list.get(i).getPhoneNo());
			userRole.setUsername(list.get(i).getUsername());
			userRole.setuId(list.get(i).getUid());
			userRole.setRole(roleList.get(list.get(i).getUserType()-1).getRoleName());
			resultList.add(userRole);
		}
		return resultList;
	}
	public List<UserRole> findEmp(String userType) {
		// TODO Auto-generated method stub
		List<UserRole> list=findAllEmployee();
		List<UserRole> resultList=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getRole().equals(userType)) {
				System.out.println("inside if ............................................................userType="+userType+" "+list.get(i).getRole());
				resultList.add(list.get(i));
			}
		}
		return resultList;
	}
	public UserRole profile(String username) {
		// TODO Auto-generated method stub
		List<User> list=entityManager.createQuery("select u from User u where u.username=:param", User.class).setParameter("param",username).getResultList();
		List<Role> roleList=entityManager.createQuery("select r from Role r").getResultList();
		User user=list.get(0);
		int userType=user.getUserType();
		String role=null;
		for(int i=0;i<roleList.size();i++) {
			if(userType==roleList.get(i).getRoleId()) {
				role=roleList.get(i).getRoleName();
				break;
			}
		}
		UserRole userRole=new UserRole();
		userRole.setName(user.getName());
		userRole.setPhoneNo(user.getPhoneNo());
		userRole.setRole(role);
		userRole.setUsername(username);
		userRole.setuId(user.getUid());
		return userRole;
	}
	

}
