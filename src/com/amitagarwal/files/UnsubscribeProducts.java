package com.amitagarwal.files;

import java.util.ArrayList;

public class UnsubscribeProducts {

	String user_id;
	ArrayList<Unsubscribe> unsubscribe;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public ArrayList<Unsubscribe> getUnsubscribe() {
		return unsubscribe;
	}
	public void setUnsubscribe(ArrayList<Unsubscribe> unsubscribe) {
		this.unsubscribe = unsubscribe;
	}
	@Override
	public String toString() {
		return "UnsubscribeProducts [user_id=" + user_id + ", unsubscribe=" + unsubscribe + "]";
	}
	
	
	
}
