package com.amitagarwal.files;

public class Payload {

	String productId;
	String url;
	String price;
	String reason;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "Payload [productId=" + productId + ", url=" + url + ", price=" + price + ", reason=" + reason + "]";
	}
	
	
	
}
