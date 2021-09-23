package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.UserDetail;
import com.revature.utils.ConnectionUtil;

public class UserDetailDao implements UserDetailDaoInterface {
	
	Logger log = (Logger) LogManager.getLogger();

	@Override
	public List<UserDetail> getUserDetails() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from user_details";
			
			Statement st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			List<UserDetail> userDetail = new ArrayList<>();
			
			while(rs.next()) {
				UserDetail ud = new UserDetail(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("user_password"),
						rs.getInt("phone_number"),
						rs.getString("country"),
						rs.getString("state"),
						rs.getString("city"),
						rs.getString("apartment_number"),
						rs.getInt("zip"),
						rs.getString("date_created_at"),
						rs.getString("date_updated_at"),
						rs.getInt("user_role_id_fk"),
						rs.getInt("account_id")
				);
				userDetail.add(ud);
			}
			return userDetail;
			
		}catch(SQLException e) {
			System.out.println("Something is wrong while retreiving info from database");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDetail> getUserDetailByUserId(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserDetails(UserDetail userdetail) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date date = new Date();
//			String currentDate = dateFormat.format(date);
			
			String sql = "insert into user_details (first_name, last_name, email, user_password,"
					+ "phone_number, country, state, city, "
					+ "apartment_number, zip, date_created_at, date_updated_at, "
					+ "user_role_id_fk, account_id)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userdetail.getFirst_name());
			ps.setString(2, userdetail.getLast_name());
			ps.setString(3, userdetail.getEmail());
			ps.setString(4, userdetail.getUser_password());
			ps.setInt(5, userdetail.getPhone_number());
			ps.setString(6, userdetail.getCountry());
			ps.setString(7, userdetail.getState());
			ps.setString(8, userdetail.getCity());
			ps.setString(9, userdetail.getApartment_number());
			ps.setInt(10, userdetail.getZip());
			ps.setString(11, userdetail.getDate_created_at());
			ps.setString(12, null);
			ps.setInt(13, userdetail.getUser_role_id_fk());
			ps.setInt(14, userdetail.getAccount_id());
			
			ps.executeUpdate();
			
			System.out.println("Mr/Ms."+ userdetail.getFirst_name() +" "+ userdetail.getLast_name()
			+ " Your Account has been successfully Created");
					
			log.info("Successfully Added User");
			
			
		}catch(SQLException e) {
			System.out.println("User Detail fail to Add, Something went wrong !!");
			e.printStackTrace();
		}

	}

	@Override
	public List<UserDetail> getUserDetailByEmail(String email) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from user_details where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			
			List<UserDetail> userDetailList = new ArrayList<>();
			
			while(rs.next()) {
				
				UserDetail ud = new UserDetail(
					rs.getInt("user_id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email"),
					rs.getString("user_password"),
					rs.getInt("phone_number"),
					rs.getString("country"),
					rs.getString("state"),
					rs.getString("city"),
					rs.getString("apartment_number"),
					rs.getInt("zip"),
					rs.getString("date_created_at"),
					rs.getString("date_updated_at"),
					rs.getInt("user_role_id_fk"),
					rs.getInt("account_id")
				);
				userDetailList.add(ud);
			}
			
			return userDetailList;
			
			
		}catch(SQLException e) {
			System.out.println("Your Information could not be obtained");
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public void updateUserDetailsByEmail(UserDetail userdetail) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update user_details set first_name = ?, last_name = ?,"
					+ " email = ?, user_password = ? , phone_number=?, country = ?,"
					+ "state =?, city = ?, apartment_number = ?, zip = ?, "
					+ "date_updated_at = ? where user_id = ? ";
			
//			String sql = "update user_details set first_name=?,last_name = ? "
//					+ "where user=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, userdetail.getFirst_name());
			ps.setString(2, userdetail.getLast_name());
			ps.setString(3, userdetail.getEmail());
			ps.setString(4, userdetail.getUser_password());
			ps.setInt(5, userdetail.getPhone_number());
			ps.setString(6, userdetail.getCountry());
			ps.setString(7, userdetail.getState());
			ps.setString(8, userdetail.getCity());
			ps.setString(9, userdetail.getApartment_number());
			ps.setInt(10, userdetail.getZip());
			ps.setString(11, userdetail.getDate_updated_at());
			
			ps.setInt(12, userdetail.getUser_id());
			
			ps.executeUpdate();
			
			System.out.println("User information has been successfully updated ");
			log.info("successfully updated the user id:" + userdetail.getUser_id());
		}catch(SQLException e) {
			
			System.out.println("Cannot Update User Information");
			e.printStackTrace();
			
		}
		
	}

}
