package com.book;

import com.book.dao.Account;
import com.book.dao.AccountDao;
import com.book.dao.AccountDaoImpl;

public class LoginBean {
	private Account param_acc=null;
	Account acc;
	public Account getReturn_acc() {
		
		
		return acc;
	}

	public void setParam_acc(Account param_acc) {
		this.param_acc = param_acc;
		AccountDao accDao=new AccountDaoImpl();
//		boolean return_acc = accDao.Chklogin(null, null)
	}
}
