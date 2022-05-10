package com.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PrintWriter out=null;
	protected <T> T Request2Bean(Class<T> cls, HttpServletRequest request){
    	try {
			T o=cls.getDeclaredConstructor().newInstance();
			Enumeration<String> paraNames = request.getParameterNames();
			while(paraNames.hasMoreElements()) {
				
				String propertyName=paraNames.nextElement();
				String propertyValue=request.getParameter(propertyName);//若get方法中文乱码   字符串得编译成二进制
				//propertyValue=new String(propertyValue.getBytes("iso-8859-1"),"UTF-8");//转码
				//但是并不推荐这样做，推荐post方法传中文
				
				setProperty(o, propertyName, propertyValue);
			}	
			return o;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
    	//return null;
    }
    
	protected <T> void setProperty(T o, String colName, Object colValue) {
		try {
			org.apache.commons.beanutils.BeanUtils.setProperty(o, colName, colValue);
		} catch (IllegalAccessException e) {
			;
		} catch (InvocationTargetException e) {
			;
		}
		
	}
    
    /**
     * @see HttpServlet#HttpServlet()
     * 反射 泛型
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","text/html;charset=UTF-8");
		
		out=response.getWriter();
		String cmd=request.getParameter("cmd");//"chklogin";
		//通过名称调用方法 java反射
		//startService(request,response);
		try {
			Method method=this.getClass().getMethod(cmd, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, request,response);
			
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("方法名称不存在！！！----"+cmd);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			;
		}
	}
	
}
