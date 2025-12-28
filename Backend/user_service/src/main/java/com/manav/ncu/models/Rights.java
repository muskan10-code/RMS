package com.manav.ncu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="right_mst")
public class Rights {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="right_id")
private int rightId;
@Column(name="right_name")
private String rightName;
public Rights() {}
public Rights(int rightId, String rightName, String rightUrl) {
	super();
	this.rightId = rightId;
	this.rightName = rightName;
	this.rightUrl = rightUrl;
}
public int getRightId() {
	return rightId;
}
public void setRightId(int rightId) {
	this.rightId = rightId;
}
public String getRightName() {
	return rightName;
}
public void setRightName(String rightName) {
	this.rightName = rightName;
}
public String getRightUrl() {
	return rightUrl;
}
public void setRightUrl(String rightUrl) {
	this.rightUrl = rightUrl;
}
@Column(name="right_url")
private String rightUrl;
}
