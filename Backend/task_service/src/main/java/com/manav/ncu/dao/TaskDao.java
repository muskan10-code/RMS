package com.manav.ncu.dao;

import java.util.Date;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.Expression;
import javax.transaction.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.manav.ncu.models.Task;
import com.manav.ncu.models.UserRole;
@Repository
@Transactional
public class TaskDao {
@PersistenceContext
private EntityManager entityManager;
@Temporal(TemporalType.TIME)
private Date date=new Date(System.currentTimeMillis());
public int addTask(Task task) {
	entityManager.persist(task);
	return task.getTaskId();
}
public List<Task> getAllTask() {
	List<Task> list=entityManager.createQuery("select t from Task t", Task.class).getResultList();
	return list;
}
public String updateStartStatus(int id) {
	// TODO Auto-generated method stub
	int num=entityManager.createQuery("Update Task set taskStatus=\'STARTED\',startTime=CURRENT_TIME  where taskId=:param").setParameter("param",id).executeUpdate();
	return num>0?"Updated Successfull":"Error IN Update";
}
public String updateFinishedStatus(int id) {
	// TODO Auto-generated method stub
	int num=entityManager.createQuery("Update Task set taskStatus=\'FINISHED\',endTime=CURRENT_TIME  where taskId=:param").setParameter("param",id).executeUpdate();
	long timediff=getTimeDiff(id);
	System.out.println("timediff="+timediff);
	List<Task> list=entityManager.createQuery("select t from Task t where taskId=:param",Task.class).setParameter("param", id).getResultList();
	int uid=list.get(0).getuId();
	System.out.println(list.get(0));
	//Adding rewards Automatically
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<>(headers);
	RestTemplate restTemplate=new RestTemplate();
	ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8083/assignreward?time={timediff}&uid={uid}", HttpMethod.GET, entity, Map.class,timediff,uid);
	if (response != null && response.getStatusCode().value() == 200) {
		String message=(String) response.getBody().get("message");
		System.out.println(message);
	}
	return num>0?"Updated Successfull":"Error IN Update";
}
public List<Task> getUserTasks(String username) {
	// TODO Auto-generated method stub
	List<Task> list=entityManager.createQuery("select t from Task t where createdBy=:param").setParameter("param", username).getResultList();
	return list;
}
public long getTimeDiff(int id) {
	Query query=entityManager.createQuery("select startTime from Task where taskId=:param").setParameter("param",id);
	Date d1= (Date) query.getSingleResult();
	Query query1=entityManager.createQuery("select endTime from Task where taskId=:param").setParameter("param",id);
	Date d2= (Date) query1.getSingleResult();
	System.out.println("D1===="+d1);
	System.out.println("D2===="+d2);
	 long diff = d2.getTime() - d1.getTime();

     long diffSeconds = diff / 1000 % 60;
     long diffMinutes = diff / (60 * 1000) % 60;
     long diffHours = diff / (60 * 60 * 1000) % 24;
     long diffDays = diff / (24 * 60 * 60 * 1000);

     System.out.print(diffDays + " days, ");
     System.out.print(diffHours + " hours, ");
     System.out.print(diffMinutes + " minutes, ");
     System.out.println(diffSeconds + " seconds.");
     long time=diffHours*60+diffMinutes;
     System.out.println(time);
     return time;
}
public int findEmployee(List<UserRole> userList,String taskType) {
	// TODO Auto-generated method stub
	List<Task> list=entityManager.createQuery("select t from Task t where taskStatus=:param1 and taskType=:param2").setParameter("param1", "Pending").setParameter("param2", taskType).getResultList();
	Map<Integer,Integer> map=new HashMap<>();
	int minTask=Integer.MAX_VALUE;
	int empId=0;
	System.out.println("list task ..............................."+list);
	if(list.size()!=0) {
	for(int i=0;i<list.size();i++) {
		System.out.println("Inside first for  ///////////////"+list.get(i).getuId());
		map.put(list.get(i).getuId(), map.getOrDefault(list.get(i).getuId(), 0)+1);
	}
	}
	for(int i=0;i<userList.size();i++) {
		if(!map.containsKey(userList.get(i).getuId())) {
			System.out.println("Inside second for  ///////////////"+userList.get(i).getuId());
			map.put(userList.get(i).getuId(),0);
		}
	}
	for(Integer i:map.keySet()) {
		if(map.get(i)<=minTask) {
			minTask=map.get(i);
			empId=i;
		}
	}
	System.out.println(map);
	return empId;
}
}
