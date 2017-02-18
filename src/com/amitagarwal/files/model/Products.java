package com.amitagarwal.files.model;

import java.util.ArrayList;
import java.util.Map;

public class Products {

	String productId;
	float currPrice;
	float allTimeLowPrice;
	Map<String,String> subscribedUsers;
	String url;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public float getCurrPrice() {
		return currPrice;
	}
	public void setCurrPrice(float currPrice) {
		this.currPrice = currPrice;
	}
	public float getAllTimeLowPrice() {
		return allTimeLowPrice;
	}
	public void setAllTimeLowPrice(float allTimeLowPrice) {
		this.allTimeLowPrice = allTimeLowPrice;
	}
	
	
	
	public Map<String, String> getSubscribedUsers() {
		return subscribedUsers;
	}
	
	public void setSubscribedUsers(Map<String, String> subscribedUsers) {
		this.subscribedUsers = subscribedUsers;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Products(String productId, float currPrice, float allTimeLowPrice,
			Map<String,String> subscribedUsers, String url) {
		super();
		this.productId = productId;
		this.currPrice = currPrice;
		this.allTimeLowPrice = allTimeLowPrice;
		this.subscribedUsers = subscribedUsers;
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", currPrice=" + currPrice + ", allTimeLowPrice=" + allTimeLowPrice
				+ ", subscribedUsers=" + subscribedUsers + ", url=" + url + "]";
	}
	
	
}


