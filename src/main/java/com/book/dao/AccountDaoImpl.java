package com.book.dao;

import java.util.List;

import com.book.entity.Account;
import com.core.DataBase;

public class AccountDaoImpl extends DataBase implements AccountDao{

	Account curAcc;
	
	@Override
	public void Reg(Account acc) {
		executeUpdate("insert into account(username,cnname,password) values(?,?,?)",acc.getUsername(),acc.getCnname(),acc.getPassword());
	}

	public void setLogin(Account v) {
		String sql="select * from account where username=?";
		List<Account> l= this.Query(Account.class,sql,v.getUsername());
		if(l.size()>0){
			Account acc=l.get(0);
			String pwd=v.getPassword();
			if(!pwd.equals(acc.getPassword())){
				throw new RuntimeException("密码错误!");
			}
			//return true;
		}else{
			//用户名错误
			throw new RuntimeException("用户名错误!");
		}
		this.curAcc=l.get(0);
	}
	
	public Account getCurAcc() {
		return this.curAcc;
	}
	@Override
	public Account Chklogin(String un, String pwd) {
		/**
		ResultSet rs=Query("select * from account where username=?",un);
		try {
			if(rs.next()){
				String p1=rs.getString("password");
				if(!pwd.equals(p1)){
					throw new RuntimeException("密码错误!");
				}
				return true;
			}else
			{
				//用户名错误
				throw new RuntimeException("用户名错误!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		**/
		String sql="select * from account where username=?";
		List<Account> l= this.Query(Account.class,sql,un);
		if(l.size()>0){
			Account acc=l.get(0);
			if(!pwd.equals(acc.getPassword())){
				throw new RuntimeException("密码错误!");
			}
			return acc;
		}else{
			//用户名错误
			throw new RuntimeException("用户名错误!");
		}
			
	}

	@Override
	public List<Account> getAllAccounts() {
		String sql="select * from account ORDER BY city desc";
		List<Account> l= this.Query(Account.class,sql);
		return l;
		/**
		ResultSet rs=Query("select * from account");
		try {
			while(rs.next()){
				//每一次循环，封装一条记录
				Account curAcc=new Account();
				curAcc.setUsername(rs.getString("username"));
				curAcc.setCnname(rs.getString("cnname"));
				curAcc.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		**/
	}

}
