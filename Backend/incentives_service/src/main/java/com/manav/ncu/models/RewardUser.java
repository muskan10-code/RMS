package com.manav.ncu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="reward_user_mapping")
public class RewardUser {
	@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int uid;
@Column(name="reward_points")
private int rewardPoints;
public RewardUser() {}
public RewardUser(int id, int uid, int rewardPoints) {
	super();
	this.id = id;
	this.uid = uid;
	this.rewardPoints = rewardPoints;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getRewardPoints() {
	return rewardPoints;
}
public void setRewardPoints(int rewardPoints) {
	this.rewardPoints = rewardPoints;
}

}
