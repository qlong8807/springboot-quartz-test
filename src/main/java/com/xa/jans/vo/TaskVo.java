package com.xa.jans.vo;

public class TaskVo {

	private String id;
	private String taskName;//任务名称
	private String taskCode;//任务代码（bean名）
	private String cron;
	private String state;
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "TaskVo [id=" + id + ", taskName=" + taskName + ", taskCode=" + taskCode + ", cron=" + cron + ", state="
				+ state + ", remark=" + remark + "]";
	}
	
	
}
