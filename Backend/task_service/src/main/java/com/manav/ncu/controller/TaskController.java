package com.manav.ncu.controller;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manav.ncu.models.Task;
import com.manav.ncu.services.TaskService;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	@PostMapping(path="/addtask" , produces= {MediaType.APPLICATION_JSON_VALUE} ,consumes={MediaType.APPLICATION_JSON_VALUE})
	public Map<String,String> addTask(@RequestBody Task task) {
		Map<String,String> map=new HashMap<>();
		System.out.println("inside thisssssssssssssssssssssssssssssssssssssss method");
		map.put("message", taskService.addTask(task));
		System.out.println("Hello inside controooooooooooooooooooooooooooooooooooooooooooooooler");
		return map;
	}
	
	@GetMapping(path="/getAllTask")
	public Map<String,List<Task>> getAllTask(){
		Map<String,List<Task>> map=new HashMap<>();
		List<Task> list=taskService.getAllTask();
		map.put("task",list );
		return map;
	}
	@GetMapping(path="/updatestartedstatus")
	public String updateStartStatus(@RequestParam(value="id") int id) {
		return taskService.updateStartStatus(id);
	}
	@GetMapping(path="/updatefinishstatus", produces= {MediaType.APPLICATION_JSON_VALUE} ,consumes={MediaType.APPLICATION_JSON_VALUE})
	public String updateFinishedStatus(@RequestParam(value="id") int id) {
		return taskService.updateFinishedStatus(id);
	}
	@GetMapping(path="/usertask")
	public Map<String,List<Task>> getUserTasks(@RequestParam(value="username") String username){
		Map<String,List<Task>> map=new HashMap<>();
		List<Task> list=taskService.getUserTasks(username);
		map.put("task", list);
		return map;
	}
}
