package com.book.dao;

import java.util.List;

public interface AccountDao {
	public void Reg(Account acc);
	public boolean Chklogin(String un,String pwd);
	//����
	public List<Account> getAllAccounts();
}
