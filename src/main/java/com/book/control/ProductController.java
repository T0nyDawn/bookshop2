package com.book.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Product;
import com.book.model.BookService;
import com.core.BaseController;
@WebServlet("/product")
public class ProductController extends BaseController {

	private static final long serialVersionUID = 1L;

	public 	void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÒµÎñ´úÂë
		/**
		String lb=request.getParameter("lb");
		int int_lb=0;
		if(lb!=null) {
			int_lb=Integer.parseInt(lb);
		}
		**/
		Product p=this.Request2Bean(Product.class, request);
		BookService bs=new BookService();
		List<Product> books= bs.getBookListByLb(p.getLb());
		request.setAttribute("books", books);
		//to view
	}
}
