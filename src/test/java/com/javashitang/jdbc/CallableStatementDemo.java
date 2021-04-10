package com.javashitang.jdbc;

import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author lilimin
 * @since 2021-04-09
 */
public class CallableStatementDemo {

    @Test
    public void test1() throws Exception {
        Connection conn = DBUtil.open();
        CallableStatement cs = conn.prepareCall("call create_kf_use_arg(5)");
        cs.execute();
        DBUtil.close(conn);
    }

    @Test
    public void test3() throws Exception {
        Connection conn = DBUtil.open();
        CallableStatement cs = conn.prepareCall("call get_kf(5)");
        cs.execute();
        ResultSet rs = cs.getResultSet();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            System.out.println(id + "," + name + "," + email);
        }
        DBUtil.close(conn);
    }
}
