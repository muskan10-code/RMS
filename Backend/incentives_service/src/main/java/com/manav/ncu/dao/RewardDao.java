package com.manav.ncu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.manav.ncu.models.RewardUser;
import com.manav.ncu.models.Rewards;

@Repository
@Transactional
public class RewardDao {
@PersistenceContext
private  EntityManager entityManager;
	public int assignReward(int time,int uid) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select r from RewardUser r where r.uid=:param",RewardUser.class).setParameter("param", uid);
		List<RewardUser> list=query.getResultList();
		int reward=getRewardDetails(time);
		System.out.println(list);
		if(list.size()==0) {
			RewardUser user=new RewardUser();
			user.setUid(uid);
			user.setRewardPoints(reward);
			entityManager.persist(user);
			return user.getId();
		}
		else {
			int num=entityManager.createQuery("UPDATE RewardUser set reward_points=reward_points+:param1 where uid=:param2").setParameter("param1", reward).setParameter("param2", uid).executeUpdate();
			return num;
		}
	}
	private int getRewardDetails(int time) {
		List<Rewards> list=entityManager.createQuery("select r from Rewards r", Rewards.class).getResultList();
		for(int i=0;i<list.size();i++) {
			if(time<=list.get(i).getTime()) {
				System.out.println("Time="+time+"Rewards="+list.get(i).getRewards());
				return list.get(i).getRewards();
			}
		}
		return -2;
	}
	public int addRewards(Rewards reward) {
		// TODO Auto-generated method stub
		entityManager.persist(reward);
		return reward.getrId();
	}
	public int addUserReward(int uid, int reward) {
		// TODO Auto-generated method stub
		int num=entityManager.createQuery("UPDATE RewardUser set reward_points=reward_points+:param1 where uid=:param2").setParameter("param1", reward).setParameter("param2", uid).executeUpdate();
		return num;
	}
	public Integer userReward(int uid) {
		// TODO Auto-generated method stub
		List<RewardUser> user=entityManager.createQuery("SELECT  r from RewardUser r where uid=:param").setParameter("param", uid).getResultList();
		if(user!=null) {
		return user.get(0).getRewardPoints();
		}
		else {
		return 0;
		}
	}

}
