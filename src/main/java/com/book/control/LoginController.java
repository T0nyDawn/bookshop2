package com.book.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Account;
import com.core.BaseController;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * @see HttpServlet#HttpServlet()
     * 反射 泛型
     */
	public void chkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
		Account acc=Request2Bean(Account.class,request);	
		System.out.println("******************");
		out.println(com.alibaba.fastjson.JSON.toJSONString(acc));
		
	}
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out.println("更改密码！！！");
		
	}

}
