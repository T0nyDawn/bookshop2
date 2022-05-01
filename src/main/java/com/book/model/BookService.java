package com.book.model;

import java.util.List;

import com.book.dao.ProductDao;
import com.book.entity.Product;
//������ҵ������ƣ����ܳ���SQL���
public class BookService {
	private ProductDao dao = new ProductDao();
	public List<Product> getBookListByLb(int lb){
		//dao.setLb(lb);
		return dao.getBookList(lb);
		
	}
	public void addOneBook(Product one) {
		String bookid=one.getProdid();
		if(dao.getBookById(bookid)!=null) {
			throw new RuntimeException("ͼ��ID�Ѿ����ڣ�����");
		}
		//�ж�����Ƿ����
		
		
		dao.add(one);
	}
	public void rk(Product one) {
		
	}
}
