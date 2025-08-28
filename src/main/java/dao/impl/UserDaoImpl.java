package dao.impl;

import model.User;
import java.sql.*;

import dao.DBConnection;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [Users] WHERE username = ?";
        try {
            conn = new DBConnection().getConnection(); // bạn cần viết DBConnection
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                return user;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
