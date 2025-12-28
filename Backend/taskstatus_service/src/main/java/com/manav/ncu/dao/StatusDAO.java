package com.manav.ncu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manav.ncu.models.Task;

@Repository
@Transactional
public class StatusDAO {
	@PersistenceContext
private EntityManager entityManager;
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		List<Task> list= entityManager.createQuery("select t from Task t where date=CURRENT_DATE", Task.class).getResultList();
		System.out.println(list);
		return list;
	}
	public long getPendingTaskCount() {
		// TODO Auto-generated method stub
		Query query =  entityManager.createQuery("select COUNT(*) from Task where taskStatus= :param").setParameter("param", "PENDING");
		Number num=(Number) query.getSingleResult();
		System.out.println(num);
		return (long) num;
	}
	public long getFinishTaskCount() {
		// TODO Auto-generated method stub
		Query query =  entityManager.createQuery("select COUNT(*) from Task where taskStatus= :param").setParameter("param", "FINISHED");
		Number num=(Number) query.getSingleResult();
		System.out.println(num);
		return (long) num;
	}
	
	public List<Task> getAssignTask(int uid) {
		// TODO Auto-generated method stub
		List<Task> list= entityManager.createQuery("select t from Task t where uid= :param and (taskStatus= :param1 or taskStatus= :param2)", Task.class).setParameter("param", uid).setParameter("param1", "Pending").setParameter("param2", "STARTED").getResultList();
		return list;
	}
	public long getAllTaskCount() {
		// TODO Auto-generated method stub
		Query query =  entityManager.createQuery("select COUNT(*) from Task where date=CURRENT_DATE");
		Number num=(Number) query.getSingleResult();
		System.out.println(num);
		return (long) num;
	}

}
