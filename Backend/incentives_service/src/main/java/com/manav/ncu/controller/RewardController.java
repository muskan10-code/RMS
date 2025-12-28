package com.manav.ncu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manav.ncu.models.Rewards;
import com.manav.ncu.service.RewardService;

@RestController
public class RewardController {
@Autowired
private RewardService rewardService;
@GetMapping(path="/assignreward")
public Map<String,String> assignReward(@RequestParam(value="time") int time,@RequestParam(value="uid") int uid) {
	System.out.print("Inside reward 777777777777777777777777777777777777");
	Map<String,String> map=new HashMap<>();
	map.put("message", rewardService.assignReward(time,uid));
	return map;
}
@PostMapping(path="/addreward")
public Map<String,String> addRewards(@RequestBody Rewards reward){
	Map<String,String> map=new HashMap<>();
	map.put("message", rewardService.addRewards(reward));
	return map;
}
@GetMapping(path="/assignuserreward")
public Map<String,String> assignUserReward(@RequestParam(value="uid") int uid,@RequestParam(value="reward") int reward){
	Map<String,String> map=new HashMap<>();
	map.put("message", rewardService.addUserRewards(uid,reward));
	return map;
}
@GetMapping(path="/userreward")
public Map<String,Integer> userReward(@RequestParam(value="username") String username){
	Map<String,Integer> map=new HashMap<>();
	map.put("rewards", rewardService.userReward(username));
	return map;
}
}

//java.net packagae call through url class