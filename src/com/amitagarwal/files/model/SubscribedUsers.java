package com.amitagarwal.files.model;

public class SubscribedUsers {

	String userId;
	String subsreason;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubsreason() {
		return subsreason;
	}
	public void setSubsreason(String subsreason) {
		this.subsreason = subsreason;
	}
	public SubscribedUsers(String userId, String subsreason) {
		super();
		this.userId = userId;
		this.subsreason = subsreason;
	}
	
	
	
}
