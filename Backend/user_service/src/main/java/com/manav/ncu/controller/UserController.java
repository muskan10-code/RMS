package com.manav.ncu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manav.ncu.models.Rights;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;
import com.manav.ncu.models.UserRole;
import com.manav.ncu.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping(path="/register")
	public Map<String,String> addUser(@RequestBody User user){
		Map<String,String> map=new HashMap<>();
		map.put("message",userService.addUser(user));
		return map;
	}
	@PostMapping(path="/addrole")
	public Map<String,String> addRole(@RequestBody Role role){
		Map<String,String> map=new HashMap<>();
		map.put("message",userService.addRole(role));
		return map;
	}
	@GetMapping(path="/finduser")
	public Map<String,String> findRole(@RequestParam(value="username") String username){
		Map<String,String> map=new HashMap<>();
		map.put("usertype", userService.findRole(username));
		return map;
	}
	@GetMapping(path="/finduserrights")
	public Map<String,List<Rights>> findRight(@RequestParam(value="username") String username){
		Map<String,List<Rights>> map=new HashMap<>();
		map.put("userrights", userService.findRight(username));
		return map;
	}
	@GetMapping(path="/findemployee")
	public Map<String,List<UserRole>> findAllEmployee(){
		Map<String,List<UserRole>> map=new HashMap<>();
		map.put("employee",userService.findAllEmployee());
		return map;
	}
	@GetMapping(path="/findemptype")
	public Map<String,List<UserRole>> findEmpType(@RequestParam(value="userType") String userType){
		Map<String,List<UserRole>> map=new HashMap<>();
		map.put("employee", userService.findEmpType(userType));
		return map;
	}
	@GetMapping(path="/profile")
	public Map<String,UserRole> profile(@RequestParam(value="username") String username){
		Map<String,UserRole> map=new HashMap<>();
		map.put("profile",userService.profile(username));
		return map;
	}
}
