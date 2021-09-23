package com.revature.models;

public class Transaction {
	
	private int transaction_id;
	private int user_id_fk;
	private int amount_deposit;
	private int amount_withdraw;
	private String amount_added_date;
	private String amount_update_date;
	private String transaction_status;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transaction_id, int user_id_fk,int amount_deposit, int amount_withdraw,
			String amount_added_date, String amount_update_date, String transaction_status) {
		super();
		this.transaction_id = transaction_id;
		this.user_id_fk = user_id_fk;
		this.amount_deposit = amount_deposit;
		this.amount_withdraw = amount_withdraw;
		this.amount_added_date = amount_added_date;
		this.amount_update_date = amount_update_date;
		this.transaction_status = transaction_status;
	}

	public Transaction(int user_id_fk, int amount_deposit, int amount_withdraw, String amount_added_date,
			String amount_update_date, String transaction_status) {
		super();
		this.user_id_fk = user_id_fk;
		this.amount_deposit = amount_deposit;
		this.amount_withdraw = amount_withdraw;
		this.amount_added_date = amount_added_date;
		this.amount_update_date = amount_update_date;
		this.transaction_status = transaction_status;
	}

	
	//Getters and Setters
	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getUser_id_fk() {
		return user_id_fk;
	}

	public void setUser_id_fk(int user_id_fk) {
		this.user_id_fk = user_id_fk;
	}


	

	public int getAmount_deposit() {
		return amount_deposit;
	}

	public void setAmount_deposit(int amount_deposit) {
		this.amount_deposit = amount_deposit;
	}

	public int getAmount_withdraw() {
		return amount_withdraw;
	}

	public void setAmount_withdraw(int amount_withdraw) {
		this.amount_withdraw = amount_withdraw;
	}

	public String getAmount_added_date() {
		return amount_added_date;
	}

	public void setAmount_added_date(String amount_added_date) {
		this.amount_added_date = amount_added_date;
	}

	public String getAmount_update_date() {
		return amount_update_date;
	}

	public void setAmount_update_date(String amount_update_date) {
		this.amount_update_date = amount_update_date;
	}
	
	
	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount_added_date == null) ? 0 : amount_added_date.hashCode());
		result = prime * result + amount_deposit;
		result = prime * result + ((amount_update_date == null) ? 0 : amount_update_date.hashCode());
		result = prime * result + amount_withdraw;
		result = prime * result + transaction_id;
		result = prime * result + ((transaction_status == null) ? 0 : transaction_status.hashCode());
		result = prime * result + user_id_fk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount_added_date == null) {
			if (other.amount_added_date != null)
				return false;
		} else if (!amount_added_date.equals(other.amount_added_date))
			return false;
		if (amount_deposit != other.amount_deposit)
			return false;
		if (amount_update_date == null) {
			if (other.amount_update_date != null)
				return false;
		} else if (!amount_update_date.equals(other.amount_update_date))
			return false;
		if (amount_withdraw != other.amount_withdraw)
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (transaction_status == null) {
			if (other.transaction_status != null)
				return false;
		} else if (!transaction_status.equals(other.transaction_status))
			return false;
		if (user_id_fk != other.user_id_fk)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", user_id_fk=" + user_id_fk + ", amount_deposit="
				+ amount_deposit + ", amount_withdraw=" + amount_withdraw + ", amount_added_date=" + amount_added_date
				+ ", amount_update_date=" + amount_update_date + ", transaction_status=" + transaction_status + "]";
	}

	
	
	
	
	
	
	

}
