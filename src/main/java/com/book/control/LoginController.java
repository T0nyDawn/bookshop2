package com.book.control;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Account;
import com.core.BaseController;
import com.core.DataBase;

/**
 * Servlet implementation class LoginController
 */
//@WebServlet("/login")   // 注解  <url-pattern>/demo</url-pattern>是xml文件里的这种
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
	 * @see HttpServlet#HttpServlet() 反射 泛型
	 */
	public void chkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		Account acc = Request2Bean(Account.class, request);
		System.out.println("******************");
		out.println(com.alibaba.fastjson.JSON.toJSONString(acc));

	}

	public void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out.println("更改密码！！！");

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 * 
	 *      public void init(ServletConfig config) throws ServletException {
	 *      DataBase.setDbServer(config.getInitParameter("DbUrl"));
	 *      //System.out.println(config.getInitParameter("DbUrl"));//DbUserName
	 *      //DataBase.url=config.getInitParameter("DbUrl");
	 *      DataBase.username=config.getInitParameter("DbUserName");//DbPassword
	 *      DataBase.password=config.getInitParameter("DbPassword");
	 * 
	 *      System.out.println(DataBase.url); System.out.println(DataBase.username);
	 *      System.out.println(DataBase.password); }
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/**
	 *
	 */
	public void init(ServletConfig config) throws ServletException {
		/*
		 * System.out.println(config.getInitParameter("DbUrl"));
		 * 
		 * System.out.println(config.getInitParameter("DbUserName"));
		 * 
		 * DataBase.url=config.getInitParameter("DbUrl");
		 */
		
		  DataBase.username = config.getInitParameter("DbUserName"); DataBase.password
		  = config.getInitParameter("DbPassword");
		  DataBase.setDbServer(config.getInitParameter("DbUrl"));
		  
		  System.out.println(DataBase.url); System.out.println(DataBase.username);
		  System.out.println(DataBase.password);
		 
		
		
	}

}
