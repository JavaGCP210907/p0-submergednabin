package com.revature.dao;

import java.util.List;

import com.revature.models.UserRole;

public interface UserRoleDaoInterface {
	
	//implement some role for user_role
	public void updateRole(int user_role_id, String role_type);
	
	public List<UserRole> getAllUserRole();
	public List<UserRole> getAllUserRoleById(int id);

}
