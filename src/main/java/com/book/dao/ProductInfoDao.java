package com.book.dao;

import java.util.List;

import com.book.entity.ProductInfo;

public class ProductInfoDao extends DataBase {
//	private String prodid;
	private List<ProductInfo> bookInfoList=null;
	public void setProdid(String prodid) {
//		this.prodid = prodid;
		bookInfoList=this.Query(ProductInfo.class, "select * from item where prodid=?",prodid);
	}
	public List<ProductInfo> getBookInfoList(){
		return bookInfoList;
	}
	
	
}
