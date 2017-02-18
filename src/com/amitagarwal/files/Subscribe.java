package com.amitagarwal.files;

public class Subscribe {

	String product_id;
	String when;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	@Override
	public String toString() {
		return "Subscribe [product_id=" + product_id + ", when=" + when + "]";
	}
	
	
	
}
