package com.book.model;

import java.util.List;

import javax.management.RuntimeErrorException;

import com.book.entity.CardItem;
import com.book.entity.Product;

public class CartService {
	public void add2Cart(String productid,List<CardItem> cart) throws Exception {
		CardItem findItem=isExist(productid,cart);
		if(findItem!=null) {
			//sl++
			findItem.setSl(findItem.getSl()+1);
		}
		else {
			CardItem one=new CardItem();
			one.setProductid(productid);
			one.setSl(1);
			//?Name getBookById
			
			BookService bs=new BookService();
			Product pr=bs.getProductByLb(productid);
			if(pr==null) {
				System.out.println("1111");
				throw new Exception("该商品已经下架了。productid="+productid);
			}
			
			one.setProduct(pr);
			
			//one.setProductname(pr.getProdname());
			//qt 其他
			cart.add(one);
		}
	}
	private CardItem isExist(String productid,List<CardItem> cart) {
		/*
		 * cart.forEach(cur->{
		 * 
		 * });
		 */
		//cart.indexOf(productid);
		int i=0;
		int cs=cart.size();//次数
		while(i<cs) {
			CardItem cur=cart.get(i);
			if(productid.equalsIgnoreCase(cur.getProductid())) {
				return cur;
			}
			i++;
		}
		
		
		return null;
	}
}
