package com.book.model;

public class CardItem {
	String productid;
	String productname;
	int sl; //数量
	double dj=0;//单价
	
	Product product;
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public double getDj() {
		return dj;
	}
	public void setDj(double dj) {
		this.dj = dj;
	}
	
	

}
