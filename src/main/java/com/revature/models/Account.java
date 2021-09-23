package com.revature.models;

public class Account {
	
	private int id;
	private String account_type;
	private int user_id_fk;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String account_type, int user_id_fk) {
		super();
		this.id = id;
		this.account_type = account_type;
		this.user_id_fk = user_id_fk;
	}
	

	
	public Account(String account_type, int user_id_fk) {
		super();
		this.account_type = account_type;
		this.user_id_fk = user_id_fk;
	}

	//getter setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getUser_id_fk() {
		return user_id_fk;
	}

	public void setUser_id_fk(int user_id_fk) {
		this.user_id_fk = user_id_fk;
	}

	//hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_type == null) ? 0 : account_type.hashCode());
		result = prime * result + id;
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
		Account other = (Account) obj;
		if (account_type == null) {
			if (other.account_type != null)
				return false;
		} else if (!account_type.equals(other.account_type))
			return false;
		if (id != other.id)
			return false;
		if (user_id_fk != other.user_id_fk)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account_type=" + account_type + ", user_id_fk=" + user_id_fk + "]";
	}
	
	
	
	
	
	
}
