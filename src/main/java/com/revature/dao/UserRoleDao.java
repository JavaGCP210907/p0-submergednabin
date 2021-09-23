package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

public class UserRoleDao implements UserRoleDaoInterface {

	@Override
	public void updateRole(int user_role_id, String role_type) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Update Failed !!");
			e.printStackTrace();
		}
		

	}

	@Override
	public List<UserRole> getAllUserRole() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from user_roles";
			
			Statement st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			List<UserRole> roleList = new ArrayList<>();
			
			while(rs.next()) {
				
				UserRole role = new UserRole(
						
						rs.getInt("user_role_id"),
						rs.getString("role_type")
				
				);
				
				roleList.add(role);
			}
			return roleList;
			
		}catch(SQLException e) {
			System.out.println("User role cannot be retreived");
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<UserRole> getAllUserRoleById(int id) {
		
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;

			String sql = "select * from user_roles where user_role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<UserRole> roleList = new ArrayList<>();
			
			while(rs.next()) {
				
				UserRole role = new UserRole(
						
						rs.getInt("user_role_id"),
						rs.getString("role_type")
				
				);
				
				roleList.add(role);
			}
			return roleList;
			
		}catch(SQLException e) {
			System.out.println("User role cannot be retreived" + id);
			e.printStackTrace();
		}
		
		return null;
	}

}
