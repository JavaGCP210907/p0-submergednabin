package com.revature.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Signed;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.signedness.qual.SignedPositive;

import com.revature.dao.TransactionDao;
import com.revature.dao.UserDetailDao;
import com.revature.dao.UserRoleDao;

public class Menu {
		
	public void displayMenu() {
		
		UserDetailDao userdao = new UserDetailDao();
		UserRoleDao roledao = new UserRoleDao();
		TransactionDao transactiondao = new TransactionDao();
		
		Logger log = (Logger) LogManager.getLogger();
		
		boolean displayMenu = true;
		
		Scanner scan = new Scanner(System.in);
		
		//Welcome Menu
		System.out.println("***************** WELCOME TO OUR ONLINE BANKING SYSTEM ***********************");
		
		while(displayMenu) {
			System.out.println("Select any Option Below to Start an Banking Transaction");
			
			System.out.println("**********Input 1 to LOGIN**************");
			
			System.out.println("**********Input 2 to CREATE ONLINE BANK ACCOUNT **************");
			
			System.out.println("**********Input Exit to close the Menu **************");
			
			String input = scan.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			
			switch(input) {
				
			case("1"):{
				System.out.println("****** Enter Your Login Credentials *****");
				System.out.println("Enter Your Email");
				String email = scan.nextLine();
				
				
				System.out.println("Enter Your Password");
				
				String password = scan.nextLine();
				
				
				List<UserDetail> usrdtl = userdao.getUserDetailByEmail(email);
				for(UserDetail ud : usrdtl) {
					int user_role_id = ud.getUser_role_id_fk();
//					
					if(user_role_id == 1) {
						
						List<UserRole> role = roledao.getAllUserRoleById(user_role_id);
						for(UserRole ur : role) {
							int roleId = ur.getUser_role_id();
							String roleType = ur.getRole_type();
									
							String userEmail = ud.getEmail();
							String userPassword = ud.getUser_password();
	
							if(email.equals(userEmail) && password.equals(userPassword) ) {
								if(user_role_id == roleId) {
									System.out.println("**** Hi "+ ud.getFirst_name()+
									" You are Logged in as a " + roleType);
									boolean displaySecondMenu = true;
									while(displaySecondMenu) {
									System.out.println("********************");
									System.out.println("Type 'statement' to view your bank statement ");
									System.out.println("Type 'deposit' to deposit into Your Account ");
									System.out.println("Type 'withdraw' to withdraw Money from Your Bank Account ");
									System.out.println("Type 'exit' to logout");
									String inputAgain = scan.nextLine();
									
										switch(inputAgain) {
										case("statement"):{
											System.out.println("********************************");
											System.out.println("*********** Statement *************");
											System.out.println("********************************");
											int id = ud.getUser_id();
											List<Transaction> transactions = transactiondao.getTransactionbyId(id);
	//										List<Transaction> tr = transactiondao.getTransactionbyId(id);
											System.out.println("Your All Transactions are listed below");
											for(Transaction t : transactions) {
												System.out.println("You "+ t.getTransaction_status()+"  "+  t.getAmount_deposit() 
												+ " on "+ t.getAmount_added_date() );
												
												
											}
											System.out.println("===================================");
											transactiondao.TotalSum(id);
											
//											displaySecondMenu = false;
											
											
											break;
										}
										
										case("deposit"):{
											System.out.println("********************************");
											System.out.println("*********** Deposit *************");
											System.out.println("********************************");
											System.out.println("Please Enter amount: ");
											
											int amount_deposit = scan.nextInt();
											if(amount_deposit < 0) {
												System.out.println("The input deposit is -ve");
												System.out.println("please Input the correct value");
												break;
												
											}else {
												
												
												scan.nextLine();
												
												int amount_withdraw = 0;
												
												int user_id_fk = ud.getUser_id();
												
												String transaction_status = "deposit";
												Transaction t = new Transaction(user_id_fk, amount_deposit, amount_withdraw, currentDate," ", transaction_status);
												transactiondao.addTransactions(t);
//												displaySecondMenu=false;
											}
											break;
											
											
										}
										case("withdraw"):{
											System.out.println("********************************");
											System.out.println("*********** Enter Amount To withdraw *************");
											int amount_withdraw = scan.nextInt();
											scan.nextLine();
											
	//										int amount_deposit = 0;
											int user_details_id = ud.getUser_id();
											String transaction_status = "withdraw";
											//if amount withdraw amount is greater than total deposit than withdraw
											
											transactiondao.getTotalAmountByIdAndAddTransaction(user_details_id, amount_withdraw);
											
//											displaySecondMenu = false;
											break;
											
										}
										case("exit"):{
											displaySecondMenu = false;
											break;
										}
										
										default:{
											System.out.println("please input as mentioned in the list");
											break;
										}
									
									
									
									}
									}
									
									
								}
								
								
								
							}else {
								System.out.println("Invalid email/Password");
							}
					}
						
					}
					
					if(user_role_id == 4) {
						
						List<UserRole> role = roledao.getAllUserRoleById(user_role_id);
						for(UserRole ur : role) {
							int roleId = ur.getUser_role_id();
							String roleType = ur.getRole_type();
									
							String userEmail = ud.getEmail();
							String userPassword = ud.getUser_password();
	
							if(email.equals(userEmail) && password.equals(userPassword) ) {
								if(user_role_id == roleId) {
									System.out.println("**** Hi "+ ud.getFirst_name()+
									" You are Logged in as a " + roleType);
									boolean displaySecondMenu = true;
									
									while(displaySecondMenu) {
									System.out.println("********************");
									System.out.println("Type 'customers' to view All Customer ");
					
									System.out.println("Type 'update customer' to Update Customer Information ");
									System.out.println("Type 'delete' to Delete Individual Customer Information ");
									System.out.println("Type 'exit' to logout");
									String inputAgain = scan.nextLine();
									
									
										switch(inputAgain) {
										case("customers"):{
											System.out.println("********************************");
											System.out.println("*********** Customer Lists *************");
											System.out.println("********************************");
											int id = ud.getUser_id();
											
											List<UserDetail> users = userdao.getUserDetails();
	//										List<Transaction> tr = transactiondao.getTransactionbyId(id);
											System.out.println("Your All Customers are listed below");
											System.out.println("ID   Firstname    LastName    Email            Phone    Country"
													+ "    City    Apartment_numer    State    Zip    UserRole    Account");
											for(UserDetail userd : users) {
												
												String user_type = null;
												
												System.out.println(userd.getUser_id() + "    " + userd.getFirst_name() + "        " +
												userd.getLast_name() + "   " +
												userd.getEmail() + "   " +
												userd.getPhone_number() + "      " + userd.getCountry() + "        " +
												userd.getCity() + "        " + userd.getApartment_number() + "         " +
												userd.getState() + "        " + userd.getZip() + "    " + 
												userd.getUser_role_id_fk() + "    " + userd.getAccount_id() );
												
												
												
								
											}
											log.info("Customer Info Listed");
						
//											displaySecondMenu = false;
											break;
										}
										
										case("customer name"):{
											System.out.println("********************************");
											System.out.println("*********** Deposit *************");
											System.out.println("********************************");
											System.out.println("Please Enter amount: ");
											
											int amount_deposit = scan.nextInt();
											if(amount_deposit < 0) {
												System.out.println("The input deposit is -ve");
												System.out.println("please Input the correct value");
												break;
												
											}else {
												
												
												scan.nextLine();
												
												int amount_withdraw = 0;
												
												int user_id_fk = ud.getUser_id();
												
												String transaction_status = "deposit";
												Transaction t = new Transaction(user_id_fk, amount_deposit, amount_withdraw, currentDate," ", transaction_status);
												transactiondao.addTransactions(t);
//												displaySecondMenu=false;
												break;
											}
											
											
										}
										case("update customer"):{
											System.out.println("********************************");
											System.out.println("*********** Enter Customer Existing Email  *************");
											String user_email = scan.nextLine();
											List<UserDetail> userdtl = userdao.getUserDetailByEmail(user_email);
											System.out.println("************Input to update information asked below**********");
											for(UserDetail u : userdtl) {
												
												
												if(u.getEmail().equals(user_email)) {
													System.out.println("First Name ");
													String first_name = scan.nextLine();
													
													System.out.println("Last Name ");
													String last_name = scan.nextLine();
													
													System.out.println("Email ");
													 user_email = scan.nextLine();
													
													System.out.println("Password");
													String user_password = scan.nextLine();
													
													System.out.println("Phone Number");
													int phone_number = scan.nextInt();
													scan.nextLine();
													
													System.out.println("Country");
													String country = scan.nextLine();
													
													System.out.println("state");
													String state = scan.nextLine();
													
													System.out.println("city");
													String city = scan.nextLine();
													
													System.out.println("apartment_number");
													String apartment_number = scan.nextLine();
													
													System.out.println("zip");
													int zip = scan.nextInt();
													scan.nextLine();
													
													String date_updated_at = currentDate;
													
													int user_role_id_fk = u.getUser_role_id_fk();
													
													int user_details_id = u.getUser_id();
													
													int account_id = u.getAccount_id();
													
													
													
													UserDetail users = new UserDetail(user_details_id, first_name, last_name, user_email,
															user_password, phone_number, country, state,
															city, apartment_number,
															zip, " ", date_updated_at, user_role_id_fk, account_id);
													
													
													userdao.updateUserDetailsByEmail(users);
													break;
												}else {
													System.out.println("UserDetails email mismatched");
													break;
//													displaySecondMenu = false;
												}
											}
											
											
//											displaySecondMenu = false;
	
											
										}
										
										case("delete"):{
											System.out.println("******************************");
											System.out.println("DELETE CUSTOMER LATEST TRANSACTION");
											System.out.println("******************************");
											System.out.println("Enter User Email: ");
											String user_email = scan.nextLine();
											userdao.getUserDetailByEmail(user_email);
											List<UserDetail> userdtl = userdao.getUserDetailByEmail(user_email);
											
											for(UserDetail udt: userdtl) {
												if(udt.getEmail().equals(user_email)) {
													int user_id = udt.getUser_id();
//													transactiondao.getLastTransactionByUserId(udt.getUser_id());
													List<Transaction> trlists = transactiondao.getLastTransactionByUserId(user_id);
													
													for(Transaction t : trlists ) {
														user_id = udt.getUser_id();
														int transaction_id = t.getTransaction_id();
														transactiondao.deleteLastTransactionsByUserId(transaction_id);
													}
													
													break;
													
													
												}else {
													System.out.println(" Data doesnot match");
													break;
												}
											}
											
											
											
											
//											displaySecondMenu = false;
											break;
										}
										case("exit"):{
											System.out.println("successfully Exited!!");
											displaySecondMenu = false;
											break;
										}
										
										default:{
											System.out.println("please input as mentioned in the list");
											displaySecondMenu =false;
											break;
										}
									
									
									
									}
									}
									
									
								}
								
								
								
							}else {
								System.out.println("Invalid email/Password");
								break;
							}
					}
					}
					
				}

				break;
				
				//operation to match the login credential goes here
			}
			
			case("2"):{
				int user_role_id = 4; //1 is customer and 2 is employee
				System.out.println("***********************************************************");
				System.out.println("Register Your Account Details");
				System.out.println("***********************************************************");
				
				System.out.println("Enter Your First Name");
				String first_name = scan.nextLine();
				
				System.out.println("Enter Your Last Name");
				String last_name = scan.nextLine();
				
				System.out.println("Enter Your email");
				String email = scan.nextLine();
				
				System.out.println("Enter Your Password");
				String user_password = scan.nextLine();

				System.out.println("Enter Your Telephone/Mobile");
				int phone_number = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter Your Country");
				String country = scan.nextLine();
				
				System.out.println("Enter Your State");
				String state = scan.nextLine();
				
				System.out.println("Enter Your City");
				String city = scan.nextLine();

				System.out.println("Enter Your Apartment Number");
				String apartment_number = scan.nextLine();
				
				System.out.println("Enter Your Zip Code");
				int zip = scan.nextInt();
				scan.nextLine();
//				List<UserRole> role = roledao.getAllUserRoleById(user_role_id);
				
				System.out.println("Enter Account Type");
				System.out.println("Type 'saving' for saving account");
				System.out.println("Type 'checking' for checking account");
				System.out.println("Type 'system-admin' for checking account");
				String account = scan.nextLine();
				
				int account_id = 0;
				if(account.equals("saving")) {
					account_id  = 1;
				}else if(account.equals("checking")) {
					account_id = 2;
				}else if(account.equals("system-admin"))
					account_id = 3;
				else {
					System.out.println("please input correct account value");
					break;
				}
				
				
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date date = new Date();
//				String currentDate = dateFormat.format(date);
				
				UserDetail udetail = new UserDetail(first_name, last_name, email, user_password,
				phone_number, country, state, city, 
				apartment_number, zip, currentDate, " ", user_role_id, account_id);
				
				userdao.addUserDetails(udetail);
				break;
				
			}
			
			case("Exit"): {
				System.out.println("Bye!! You are Exited!!");
				displayMenu=false;
				break;
			}
			default:{
				System.out.println("Input a right value as mentioned");
				break;
			}
			
			}//switch loop ends
			
		}
		scan.close();
		
		
	}
}
