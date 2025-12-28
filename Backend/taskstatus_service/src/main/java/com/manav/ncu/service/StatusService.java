package com.manav.ncu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manav.ncu.helper.StatusHelper;
import com.manav.ncu.models.Task;

@Service
public class StatusService {
@Autowired 
StatusHelper statusHelper;
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return statusHelper.getAllTask();
	}
	public long getPendingTaskCount() {
		// TODO Auto-generated method stub
		return statusHelper.getPendingTaskCount();
	}
	public long getFinishTaskCount() {
		// TODO Auto-generated method stub
		return statusHelper.getFinishTaskCount();
	}
	public List<Task> getAssignTask(String username) {
		// TODO Auto-generated method stub
		return statusHelper.getAssignTask(username);
	}
	public long getAllTaskCount() {
		// TODO Auto-generated method stub
		return statusHelper.getAllTaskCount();
	}

}
