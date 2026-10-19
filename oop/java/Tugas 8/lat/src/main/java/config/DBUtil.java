package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String dbUrl = "jdbc:mysql://localhost:3306/latihan_8";
    private static String dbUsn = "root";
    private static String dbPw = "";

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsn, dbPw);
    }
}
