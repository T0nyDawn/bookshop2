package com.book.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.book.entity.CardItem;
import com.book.model.CartService;
import com.core.BaseController;
@WebServlet("/cart")
public class CartController extends BaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void show2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jdsfjkas
		//System.out.println("productid=");
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	public void add2Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productid=request.getParameter("productid");
		CartService cs=new CartService();
		System.out.println("productid="+productid);
		List<CardItem> cart=null;
		Object o=session.getAttribute("cart");
		if(o!=null) {
			cart=(List<CardItem>)o;
		}else {
			cart=new ArrayList<CardItem>();
			session.setAttribute("cart", cart);
		}
		try {
			cs.add2Cart(productid, cart);
		}catch(Exception e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		session.setAttribute("cart", cart);
		showCart(request,response);
		//to view
		//request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
