package com.book.model;

import java.util.List;

import com.book.dao.ProductDao;
import com.book.entity.Product;
//这里是业务的名称，不能出现SQL语句
public class BookService {
	private ProductDao dao = new ProductDao();
	public List<Product> getBookListByLb(int lb){
		//dao.setLb(lb);
		return dao.getBookList(lb);
		
	}
	public void addOneBook(Product one) {
		String bookid=one.getProdid();
		if(dao.getBookById(bookid)!=null) {
			throw new RuntimeException("图书ID已经存在！！！");
		}
		//判断类别是否存在
		
		
		dao.add(one);
	}
	public void rk(Product one) {
		
	}
}
