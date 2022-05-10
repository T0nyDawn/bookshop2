package com.book.dao;

import java.util.List;

import com.book.entity.Product;
import com.core.DataBase;
//DAO SQL语句写在这里
public class ProductDao extends DataBase{
	/**
//	private int lb;
	private List<Product> bookList=null;
	public void setLb(int lb) {
//		this.lb = lb;
		List<Product> bookList=this.Query( Product.class, "select * from product where lb=?",lb);
	}
	**/
	public List<Product> getBookList(int lb){
		List<Product> bookList=this.Query( Product.class, "select * from product where lb=?",lb);
		return bookList;
	}
	
	public void add(Product book) {
		//?todo 字段太多怎么办
		this.executeUpdate("insert into product(prodid,prodname,lb) values(?,?,?)",book.getProdid(),book.getProdname(),book.getLb());
	}
	public Product getBookById(String prodid) {
		List<Product> bookList=this.Query( Product.class, "select * from product where prodid=?",prodid);
		if(bookList.size()>0) {
			return bookList.get(0);
		}else
		{
			return null;
		}
		
	}
}
