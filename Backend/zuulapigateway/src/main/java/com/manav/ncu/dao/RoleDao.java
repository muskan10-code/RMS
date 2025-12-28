package com.manav.ncu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manav.ncu.controller.Controller;
import com.manav.ncu.models.Role;

@Repository
@Transactional
public class RoleDao {
	@PersistenceContext
	private  EntityManager entityManager;
	@Autowired
	private Controller controller;
	public Role findRole(int rid){
	List<Role> list=entityManager.createQuery("select r from Role r where role_id=:param").setParameter("param",rid).getResultList();
	controller.setRole(list.get(0).getRoleName());
	return list.get(0);
	}
}
