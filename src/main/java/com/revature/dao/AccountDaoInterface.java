package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface AccountDaoInterface {
	
	public List<Account> getAllAccountLists();
	
	public List<Account> getAccountById(int id);
	
	public List<Account> getAccountByUserId(int user_id); //user_id is an foreign key of user_details
	
	
}
