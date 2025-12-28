package com.manav.ncu.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="task_mst")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tid")
	private int taskId;
	@Column(name="tname")
	private String taskName;
	@Column(name="tdescr")
	private String taskDescr;
	@Column(name="tstatus")
	private String taskStatus="Pending";
	@Column(name="ttype")
	private String taskType;
	@Column(name="createdby")
	private String createdBy;
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date=new Date(System.currentTimeMillis());
	@Column(name = "start_time")
	@Temporal(TemporalType.TIME)
	private Date startTime=new Date(System.currentTimeMillis());;
	@Column(name = "end_time")
	@Temporal(TemporalType.TIME)
	private Date endTime=new Date(System.currentTimeMillis());;
	public Task() {}
	public Task(int taskId, String taskName, String taskDescr, String taskStatus, String taskType, String createdBy,
			Date date, Date startTime, Date endTime) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescr = taskDescr;
		this.taskStatus = taskStatus;
		this.taskType = taskType;
		this.createdBy = createdBy;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDescr=" + taskDescr + ", taskStatus="
				+ taskStatus + ", taskType=" + taskType + ", createdBy=" + createdBy + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescr() {
		return taskDescr;
	}
	public void setTaskDescr(String taskDescr) {
		this.taskDescr = taskDescr;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
