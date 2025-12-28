package com.manav.ncu.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.manav.ncu.dao.StatusDAO;
import com.manav.ncu.models.Task;
import com.manav.ncu.models.UserRole;

@Component
public class StatusHelper {
@Autowired
private StatusDAO statusDao;
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return statusDao.getAllTask();
	}
	public long getPendingTaskCount() {
		// TODO Auto-generated method stub
		return statusDao.getPendingTaskCount();
	}
	public long getFinishTaskCount() {
		// TODO Auto-generated method stub
		return statusDao.getFinishTaskCount();
	}
	public List<Task> getAssignTask(String username) {
		// TODO Auto-generated method stub
		List<Map<String, String>> list = null;
		List<UserRole> userList = new ArrayList<UserRole>();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange("http://localhost:8085/findemployee", HttpMethod.GET, entity, Map.class);
		if (response != null && response.getStatusCode().value() == 200) {
		    list = (List<Map<String,String>>) response.getBody().get("employee"); // this depends on the response
		    for (Map item : list) { // we iterate for each one of the items of the list transforming it
		        UserRole user = transform(item);
		        if(user.getUsername().equals(username)) {
		        	return statusDao.getAssignTask(user.getuId());
		        }
		        userList.add(user);
		    }
		}
		return null;
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
	public long getAllTaskCount() {
		// TODO Auto-generated method stub
		return statusDao.getAllTaskCount();
	}

}
