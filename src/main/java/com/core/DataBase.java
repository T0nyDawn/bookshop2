package com.core;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
	public static String  url="jdbc:mysql://127.0.0.1:3306/book?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
	public static String username="root";
	public static String password="022416";
	//private  String  url；
	
	//1-属性文件
	//2-事务
	//3-封装性,泛型、反射
	
	public static void setDbServer(String value) {
		url="jdbc:mysql://"+value+"/book?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
	}
	private Connection cn=null;
	public DataBase(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("mySql驱动未发现："+e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void executeUpdate(String sql){
		try {
			java.sql.Statement st=cn.createStatement();
			st.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeUpdate(String sql,Object... args){
		try {
			//java.sql.Statement st=cn.createStatement();
			java.sql.PreparedStatement pst=cn.prepareStatement(sql);
			
			//参数
			int i=0;
			while(i<args.length){
				pst.setObject(i+1, args[i]);
				i++;
			}
			//st.executeUpdate(sql);
			pst.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet Query(String sql,Object... args){
		try {
			java.sql.PreparedStatement pst=cn.prepareStatement(sql);
			//参数
			int i=0;
			while(i<args.length){
				pst.setObject(i+1, args[i]);
				i++;
			}
			//pst.executeQuery(sql);
			return pst.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public <T> List<T> Query(Class<T> cls,String sql,Object... args){
		ResultSet rs=Query(sql,args);
		//rs-->List
		List<T> l= ResultSet2List(cls,rs);
		return l;
	}
	public <T> List<T> Query(Class<T> cls,String sql){
		ResultSet rs=Query(sql);
		//rs-->List
		List<T> l= ResultSet2List(cls,rs);
		return l;
	}
	
	private <T> List<T> ResultSet2List(Class<T> cls, ResultSet rs) {
		List<T> l=new ArrayList<T>();
		//rs-->l
		try {
			while(rs.next()){
				//每一次循环，封装一条记录
				T o=null;
				try {
					o = cls.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSetMetaData rsm=rs.getMetaData();
				int cols=rsm.getColumnCount();
				int i=1;
				while(i<=cols){
					//处理一个字段
					String colName=rsm.getColumnName(i);
					Object colValue=rs.getObject(i);
					//反射
					//o.setUsername(rs.getString("username"));
					setProperty(o,colName,colValue);
					i++;
				}
				//curAcc.setCnname(rs.getString("cnname"));
				//curAcc.setPassword(rs.getString("password"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	private <T> void setProperty(T o, String colName, Object colValue) {
		try {
			org.apache.commons.beanutils.BeanUtils.setProperty(o, colName, colValue);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			;
		}
		
	}
	public ResultSet Query(String sql){
		try {
			java.sql.Statement st=cn.createStatement();
			return st.executeQuery(sql);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args)  {
		//DataBase db=new DataBase();
		//db.executeUpdate("insert into account(username,cnname,password) values(?,?,?)","ls","历史的","123");
		//AccountDao accDao=new AccountDaoImpl();
		//Account acc=new AccountDaoImpl();
		//accDao.Chklogin("zs", "123qq");
		//System.out.println(acc.getUsername());
	}

}
