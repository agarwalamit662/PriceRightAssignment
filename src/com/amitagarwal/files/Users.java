package com.amitagarwal.files;

import java.util.ArrayList;

public class Users {

	String user_id;
	ArrayList<Subscribe> subscribe;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public ArrayList<Subscribe> getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(ArrayList<Subscribe> subscribe) {
		this.subscribe = subscribe;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", subscribe=" + subscribe + "]";
	}
	
	
	
}
