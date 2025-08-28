package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "BTH02";
    private final String portNumber = "1433";
    private final String userID = "sa";               // user SQL Authentication
    private final String password = "123456";   // mật khẩu sa

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName + ";encrypt=false;";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            Connection conn = new DBConnection().getConnection();
            if (conn != null) {
                System.out.println("Kết nối SQL Server thành công với user sa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
