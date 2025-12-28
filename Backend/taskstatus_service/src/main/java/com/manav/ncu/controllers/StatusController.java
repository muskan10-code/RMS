package com.manav.ncu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manav.ncu.models.Task;
import com.manav.ncu.service.StatusService;

@RestController
public class StatusController {
@Autowired
private StatusService statusService;
@GetMapping(path="/getalltask")
public Map<String,List<Task>> getAllTask(){
	List<Task> list=statusService.getAllTask();
	Map<String,List<Task>> map=new HashMap<>();
	map.put("task",list);
	return map;
}
@GetMapping(path="/getpendingcount")
public Map<String,Long> getPendingTaskCount(){
	Map<String,Long> map=new HashMap<>();
	long num=statusService.getPendingTaskCount();
	map.put("pendingcount", num);
	return map;
}
@GetMapping(path="/getfinishcount")
public Map<String,Long> getFinishTaskCount(){
	Map<String,Long> map=new HashMap<>();
	long num=statusService.getFinishTaskCount();
	map.put("finishcount", num);
	return map;
}
@GetMapping(path="/getassignTask")
public Map<String,List<Task>> getAssignTask(@RequestParam(value="username") String username){
	List<Task> list=statusService.getAssignTask(username);
	Map<String,List<Task>> map=new HashMap<>();
	map.put("tasks", list);
	return map;
}
@GetMapping(path="getAllTaskCount")
public Map<String,Long> getAllTaskCount(){
	Map<String,Long> map=new HashMap<>();
	map.put("totalcount", statusService.getAllTaskCount());
	return map;
}
}
