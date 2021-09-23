package com.revature.dao;

import java.util.List;

import com.revature.models.UserDetail;

public interface UserDetailDaoInterface {
	
	public List<UserDetail> getUserDetails();//list all users information
	
	public List<UserDetail> getUserDetailByUserId(String user_id); //
	
	public List<UserDetail> getUserDetailByEmail(String email);
	
	public void addUserDetails(UserDetail userdetail);
	
	public void updateUserDetailsByEmail(UserDetail userdetail);
}
