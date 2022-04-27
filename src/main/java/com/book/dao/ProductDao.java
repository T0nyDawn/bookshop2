package com.book.dao;

import java.util.List;

import com.book.entity.Product;

public class ProductDao extends DataBase{
//	private int lb;
	private List<Product> bookList=null;
	public void setLb(int lb) {
//		this.lb = lb;
		bookList=this.Query( Product.class, "select * from product where lb=?",lb);
	}
	public List<Product> getBookList(){
		return bookList;
	}
	
	
}
