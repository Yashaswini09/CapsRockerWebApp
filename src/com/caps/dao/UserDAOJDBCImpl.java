package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.caps.beans.User;

public class UserDAOJDBCImpl implements UserDAO {

	private String dbUrl = "jdbc:mysql://localhost:3306/caps_rockers_db";
	private String username = "root";
	private String passwd = "root";
	
	public UserDAOJDBCImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean createProfile(User user) {
		// Get the DB connection
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean state = false;
		try {
			con = DriverManager.getConnection(dbUrl, username, passwd);
			String sql = "insert into users_info values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			int count = pstmt.executeUpdate();
			if(count > 0) {
				state = true;
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return state;
	}

}
