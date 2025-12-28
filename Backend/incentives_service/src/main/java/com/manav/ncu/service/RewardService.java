package com.manav.ncu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manav.ncu.helper.RewardHelper;
import com.manav.ncu.models.Rewards;

@Service
public class RewardService {
@Autowired
private RewardHelper rewardHelper;
	public String assignReward(int time,int uid) {
		// TODO Auto-generated method stub
		return rewardHelper.assignReward(time,uid);
	}
	public String addRewards(Rewards reward) {
		// TODO Auto-generated method stub
		return rewardHelper.addRewards(reward);
	}
	public String addUserRewards(int uid, int reward) {
		// TODO Auto-generated method stub
		return rewardHelper.addUserReward(uid,reward);
	}
	public Integer userReward(String username) {
		// TODO Auto-generated method stub
		return rewardHelper.userReward(username);
	}

}
