package cib.javase.project.oe.customer;

import cib.javase.project.oe.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyHandler {


    public static void insertCompany(Company c) {

        String sql =
            "INSERT INTO CUSTOMERS" +
            " (CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_TYPE_ID, CUSTOMER_CONTACT, CUSTOMER_DISCOUNT)" +
            " VALUES(?,?,?,?,?,?)";

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getPhone());
            ps.setInt(4, 2);
            ps.setString(5, c.getContact());
            ps.setInt(6, c.getDiscount());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }

    public static Company getCompany(int customerId) {
        String sql =
            "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_CONTACT, CUSTOMER_DISCOUNT" +
            " FROM CUSTOMERS" + " WHERE CUSTOMER_TYPE_ID = 2 AND CUSTOMER_ID = " + customerId;

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Company c = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Company(rs.getInt("CUSTOMER_ID"), rs.getString("CUSTOMER_ADDRESS"),
                                rs.getString("CUSTOMER_NAME"), rs.getString("CUSTOMER_PHONE"),
                                rs.getString("CUSTOMER_CONTACT"), rs.getInt("CUSTOMER_DISCOUNT"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closeResultSet(rs);
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }

        return (c == null) ? null : c;
    }
}
