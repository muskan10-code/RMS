package com.manav.ncu.helpers;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.manav.ncu.dao.TaskDao;
import com.manav.ncu.models.Task;
import com.manav.ncu.models.UserRole;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
@Component
public class TaskHelper {
	@Autowired
	private TaskDao taskDao;
	@Autowired
	RestTemplate restTemplate;
	public String addTask(Task task) {
		List<Map<String, String>> list = null;
		List<UserRole> userList = new ArrayList<UserRole>();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		restTemplate=new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8085/findemptype?userType={userType}", HttpMethod.GET, entity, Map.class,task.getTaskType());
		if (response != null && response.getStatusCode().value() == 200) {
		    list = (List<Map<String,String>>) response.getBody().get("employee"); // this depends on the response
		    for (Map item : list) { // we iterate for each one of the items of the list transforming it
		        UserRole user = transform(item);
		        userList.add(user);
		    }
		}
		int empId=taskDao.findEmployee(userList,task.getTaskType());
		System.out.println(empId);
		task.setuId(empId);
		return taskDao.addTask(task)!=0?"SuccessFully Added":"Error";
	}
	private UserRole transform(Map item) {
		// TODO Auto-generated method stub
		UserRole user=new UserRole();
		user.setName((String) item.get("name"));
		user.setPhoneNo((String) item.get("phoneNo"));
		user.setRole((String) item.get("role"));
		user.setUsername((String) item.get("username"));
		user.setuId((int) item.get("uId"));
		return user;
	}
	public List<Task> getAllTask(){
		return taskDao.getAllTask();
	}
	public String updateStartStatus(int id) {
		// TODO Auto-generated method stub
		return taskDao.updateStartStatus(id);
	}
	public String updateFinishedStatus(int id){
		// TODO Auto-generated method stub
		return taskDao.updateFinishedStatus(id);
	}
	public List<Task> getUserTasks(String username) {
		// TODO Auto-generated method stub
		return taskDao.getUserTasks(username);
	}
}
