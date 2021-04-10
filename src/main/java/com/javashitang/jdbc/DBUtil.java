package com.javashitang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lilimin
 * @since 2021-04-09
 */
public class DBUtil {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://www.javashitang.com:3306/test?noAccessToProcedureBodies=true";
        username = "test";
        password = "test";
    }

    public static Connection open() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

