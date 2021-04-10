package com.javashitang.jdbc;

import java.sql.*;

public class Test {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://www.javashitang.com/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "test", "test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select id, name, email from customertbl";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                System.out.println(id + "," + name + "," + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
