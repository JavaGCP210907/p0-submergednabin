package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Transaction;
import com.revature.utils.ConnectionUtil;

public class TransactionDao implements TransactionDaoInterface {
	
	Logger log = (Logger) LogManager.getLogger();

	@Override
	public List<Transaction> getAllTransactionLists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactionbyId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			String sql = "select * from transactions where user_id_fk = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			List<Transaction> transactionList = new ArrayList<>();
			
			while(rs.next()) {
				Transaction t = new Transaction(
						rs.getInt("transaction_id"),
						rs.getInt("user_id_fk"),
						rs.getInt("amount_deposit"),
						rs.getInt("amount_withdraw"),
						rs.getString("amount_added_date"),
						rs.getString("amount_update_date"),
						rs.getString("transaction_status")
				);
				
				transactionList.add(t);
				
			}
			return transactionList;
			
		}catch(SQLException e) {
			System.out.println("Your Statement cannot be retreived");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addTransactions(Transaction transaction) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into transactions (user_id_fk, amount_deposit, amount_withdraw, amount_added_date, transaction_status)"
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, transaction.getUser_id_fk());
			ps.setInt(2, transaction.getAmount_deposit());
			ps.setInt(3, transaction.getAmount_withdraw());
			ps.setString(4, transaction.getAmount_added_date());
			ps.setString(5, transaction.getTransaction_status());
			
			ps.executeUpdate();
			
			System.out.println("Transaction Completed Successfully");
			
			log.info("Transaction of user_id: "+ transaction.getUser_id_fk() + " is successfuly added");
		}catch(SQLException e) {
			System.out.println("Your Transaction cannot be completed!!");
			e.printStackTrace();
			log.info(" Transaction cannot be completed!!");
		}

	}

	@Override
	public void deleteTransactions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTransactions(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getTotalAmountByIdAndAddTransaction(int id, int amount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			
			ResultSet rs = null;

			String sql = "select sum(amount_deposit) AS total  from transactions GROUP BY user_id_fk having user_id_fk=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			boolean result = rs.next();
			
			if(result==true) {
				System.out.println(rs.getInt("total"));
				int total = rs.getInt("total");
				//checking withdraw inputed amount is greater than total amount
				if(total > amount) {
					
					String sql2 = "insert into transactions (user_id_fk, amount_deposit, amount_withdraw, amount_added_date, transaction_status)"
							+ "values(?,?,?,?,?)";
					PreparedStatement ps1 = conn.prepareStatement(sql2);
					ps1.setInt(1, id);
					ps1.setInt(2, -(amount));
					ps1.setInt(3, 0);
					ps1.setString(4, currentDate);
					ps1.setString(5, "withdraw");
					
					ps1.executeUpdate();
					
					System.out.println("Withdraw Completed Successfully");
					
					System.out.println("=================================");
					
					log.info("User with user_id: " + id + " withdraw amount: " + amount);
					
				}else {
					System.out.println("You don't have enough total balance");
					System.out.println("=================================");
					log.info("withdrawing by user_id: " + id + " fails");
				}
				
				
				
			}else {
				System.out.println("No data found");
				log.info("withdrawing by user_id: " + id + " fails as there is no data in database");
			}
			
			
		}catch(SQLException e) {
			System.out.println("Total Sum cannot be retreived");
			e.printStackTrace();
		}
	}

	@Override
	public void TotalSum(int user_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			
			ResultSet rs = null;

			String sql = "select sum(amount_deposit) AS total  from transactions GROUP BY user_id_fk having user_id_fk=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);

			rs = ps.executeQuery();
			boolean result = rs.next();
			
			if(result==true) {
				System.out.println("Your total remaining balance is "  + rs.getInt("total"));
				
				
			}else {
				System.out.println("No data found");
			}
			
			log.info("total balance is successfully loaded");
			
		}catch(SQLException e){
			System.out.println("Total Sum calculation went wrong");
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteLastTransactionsByUserId(int transaction_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from transactions where transaction_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, transaction_id);
			
			ps.executeUpdate();
			
			System.out.println("Deletion of Last transaction is successful");
			log.info("Transaction id: " + transaction_id + " is successfully deleted from database" );
			
		}catch(SQLException e) {
			System.out.println("Transaction deletion fail");
			e.printStackTrace();
			log.info("transaction deletion fail.");
		}
	}

	@Override
	public List<Transaction> getLastTransactionByUserId(int user_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from transactions group by transaction_id having user_id_fk = ? ORDER BY transaction_id desc limit 1 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			List<Transaction> transactionList = new ArrayList<>();
			while(rs.next()) {
				Transaction t = new Transaction(
						rs.getInt("transaction_id"),
						rs.getInt("user_id_fk"),
						rs.getInt("amount_deposit"),
						rs.getInt("amount_withdraw"),
						rs.getString("amount_added_date"),
						rs.getString("amount_update_date"),
						rs.getString("transaction_status")
				);
				
				transactionList.add(t);
			}
			return transactionList;
			
			
		}catch(SQLException e) {
			System.out.println("Couldnot find last transaction");
		}
		
		return null;
		
	}

}
