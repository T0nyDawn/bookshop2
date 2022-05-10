package com.book.dao;

import java.util.List;

import com.book.entity.Account;

public interface AccountDao {
	public void Reg(Account acc);
	public Account Chklogin(String un,String pwd);
	//·ºÐÍ
	public List<Account> getAllAccounts();
}
