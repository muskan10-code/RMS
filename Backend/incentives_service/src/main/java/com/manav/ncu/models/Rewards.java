package com.manav.ncu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rewards")
public class Rewards {
@Column(name="rid")
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int rId;
public Rewards() {}
public Rewards(int rId, int time, int rewards) {
	super();
	this.rId = rId;
	this.time = time;
	this.rewards = rewards;
}
public int getrId() {
	return rId;
}
public void setrId(int rId) {
	this.rId = rId;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public int getRewards() {
	return rewards;
}
public void setRewards(int rewards) {
	this.rewards = rewards;
}
private int time;
private int rewards;
}
