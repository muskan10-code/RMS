package com.manav.ncu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private String role;
public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
@GetMapping(path="/loginuser")
public ResponseEntity<Map<String,String>> login() {
	System.out.print("Hello login &&&&&&&&&&&&&&$$$$$$$$$$$");
	Map<String,String> map=new HashMap<>();
	//map.put("message", "hello to login");
	map.put("role", getRole());
	System.out.print(getRole());
	return new ResponseEntity<>(map,HttpStatus.OK);
}
@GetMapping(path="/find")
public String find() {
	System.out.println("inside controller");
	return "Hello Api Gateway";
}
@GetMapping(path="/payment")
public String payment() {
	return "Hello to payment";
}
@GetMapping(path="/contactme")
public String contact() {
	return "Hello to contactme";
}
}
