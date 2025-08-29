package dao.impl;

import model.User;
import java.sql.*;

import dao.DBConnection;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public UserDaoImpl() {
	    try {
	        conn = new DBConnection().getConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public User get(String username) {
		String sql = "SELECT * FROM [Users] WHERE username = ?";
		try {
			//thừa tạo conn, đang fix lỗi
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setPassWord(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(rs.getInt("roleid"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO Users (username, password, email, phone, fullname, roleid, createdDate) VALUES (?, ?, ?, ?, ?, ?, GETDATE())";
		try {
			//thừa tạo conn, đang fix lỗi
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getFullName());
			ps.setInt(6, user.getRoleId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		try {
			String sql = "SELECT 1 FROM Users WHERE email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		try {
			String sql = "SELECT 1 FROM Users WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		try {
			String sql = "SELECT 1 FROM Users WHERE phone=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User getByEmail(String email) {
	    String sql = "SELECT * FROM Users WHERE email = ?";
	    try {
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUserName(rs.getString("username"));
	            user.setPassWord(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            user.setFullName(rs.getString("fullname"));
	            user.setPhone(rs.getString("phone"));
	            user.setAvatar(rs.getString("avatar"));
	            user.setRoleId(rs.getInt("roleid"));
	            user.setCreatedDate(rs.getDate("createdDate"));
	            return user;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
