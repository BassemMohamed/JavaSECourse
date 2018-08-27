package cib.javase.project.oe.customer;

import cib.javase.project.oe.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class CustomerHandler {

    public static void insertCustomer(Customer cus) {

        String sql =
            "INSERT INTO CUSTOMERS" + " (CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_TYPE_ID)" +
            " VALUES(?,?,?,?)";

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setString(3, cus.getPhone());
            ps.setInt(4, 0);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }

    public static ArrayList<Customer> getAllCustomers() {
        String sql =
            "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE" + " FROM CUSTOMERS" +
            " WHERE CUSTOMER_TYPE_ID = 0";

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Customer c =
                    new Customer(rs.getInt("CUSTOMER_ID"), rs.getString("CUSTOMER_ADDRESS"),
                                 rs.getString("CUSTOMER_NAME"), rs.getString("CUSTOMER_PHONE"));
                cusList.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closeResultSet(rs);
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }

        return cusList;
    }

    public static Customer getCustomer(int customerId) {
        String sql =
            "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE" + " FROM CUSTOMERS" +
            " WHERE CUSTOMER_TYPE_ID = 0 AND CUSTOMER_ID = " + customerId;

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Customer(rs.getInt("CUSTOMER_ID"), rs.getString("CUSTOMER_ADDRESS"),
                                 rs.getString("CUSTOMER_NAME"), rs.getString("CUSTOMER_PHONE"));
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

    public static void removeCustomer(int customerId) {
        String sql = "DELETE FROM CUSTOMERS" + " WHERE CUSTOMER_ID = " + customerId;

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }

    public static void updateCustomer(Customer cus) {
        String sql =
            "UPDATE CUSTOMERS" + " SET CUSTOMER_NAME = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_PHONE = ? " +
            " WHERE CUSTOMER_TYPE_ID = 0 AND CUSTOMER_ID = " + cus.getId();

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setString(3, cus.getPhone());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }

}
