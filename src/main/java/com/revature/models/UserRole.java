package com.revature.models;

public class UserRole {
	
	private int user_role_id;
	private String role_type;
	
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserRole(int user_role_id, String role_type) {
		super();
		this.user_role_id = user_role_id;
		this.role_type = role_type;
	}
	
	

	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_type == null) ? 0 : role_type.hashCode());
		result = prime * result + user_role_id;
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
		UserRole other = (UserRole) obj;
		if (role_type == null) {
			if (other.role_type != null)
				return false;
		} else if (!role_type.equals(other.role_type))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [user_role_id=" + user_role_id + ", role_type=" + role_type + "]";
	}
	
	
	
	
}
