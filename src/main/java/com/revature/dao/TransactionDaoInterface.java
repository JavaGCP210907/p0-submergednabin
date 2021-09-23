package com.revature.dao;

import java.util.List;

import com.revature.models.Transaction;

public interface TransactionDaoInterface {
	
	//all the userTransaction methods will be defined here
	List<Transaction> getAllTransactionLists();
	
	List<Transaction> getTransactionbyId(int id);
	
	List<Transaction> getLastTransactionByUserId(int transaction_id); //find last inserted transaction
	
	public void getTotalAmountByIdAndAddTransaction(int id, int amount);
	
	public void TotalSum( int user_id);
	
	public void addTransactions(Transaction transaction);
	
	public void deleteTransactions();
	
	public void deleteLastTransactionsByUserId(int user_id);
	
	public void updateTransactions(int id);
	
	
}
