package com.manav.ncu.services;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manav.ncu.helpers.TaskHelper;
import com.manav.ncu.models.Task;

@Service
public class TaskService {
@Autowired
private TaskHelper taskHelper;
public String addTask(Task task) {
	return taskHelper.addTask(task);
}
public List<Task> getAllTask(){
	return taskHelper.getAllTask();
}
public String updateStartStatus(int id) {
	// TODO Auto-generated method stub
	return taskHelper.updateStartStatus(id);
}
public String updateFinishedStatus(int id)  {
	// TODO Auto-generated method stub
	return taskHelper.updateFinishedStatus(id);
}
public List<Task> getUserTasks(String username) {
	// TODO Auto-generated method stub
	return taskHelper.getUserTasks(username);
}
}
