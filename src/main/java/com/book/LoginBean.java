package com.book;

import com.book.dao.AccountDao;
import com.book.dao.AccountDaoImpl;
import com.book.entity.Account;
import com.book.except.PasswordErrorException;
import com.book.except.UserNameErrorException;

public class LoginBean {
	private  Account param_acc=null;
	private  Account return_acc=null;
	private  int  errCode=0;
		
	public int getErrCode() {
		return errCode;
	}

	public Account getReturn_acc() {
		//System.out.println("****@@@@@@@@@****");
		return return_acc;
	}

	public void setParam_acc(Account param_acc) {
		//System.out.println("****======************");
		AccountDao accDao=new AccountDaoImpl();
		try {
			return_acc= accDao.Chklogin(param_acc.getUsername(), param_acc.getPassword());
		}catch(PasswordErrorException e) {
			//得知道 什么错误
			errCode=2;
		}
		catch(UserNameErrorException e1) {
			//得知道 什么错误
			errCode=1;
		}
		this.param_acc = param_acc;
	}
	
}
