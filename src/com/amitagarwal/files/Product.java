package com.amitagarwal.files;

public class Product {

	String product_id;
	float price;
	String url;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", price=" + price + ", url=" + url + "]";
	}
	
	
	
}
