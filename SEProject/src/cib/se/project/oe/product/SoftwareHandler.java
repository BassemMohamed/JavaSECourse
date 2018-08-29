package cib.se.project.oe.product;

import cib.se.project.oe.customer.Customer;
import cib.se.project.oe.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class SoftwareHandler {

    public static void insertSoftware(Software s) {

        String sql = "INSERT INTO PRODUCTS" + "(PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)" + " VALUES(?,?,?)";

        Connection conn = DBConnectionFactory.initConn(false);
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setDouble(2, s.getPrice());
            ps.setString(3, s.getDescription());
            ps.executeUpdate();

            sql = "INSERT INTO SOFTWARE" + "(SOFTWARE_LICENCE, PRODUCT_ID)" + " VALUES(?,PRODUCTS_SEQ.CURRVAL)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, s.getLicense());
            ps.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }


    public static Software getSoftware(int softwareId) {
        String sql =
            "SELECT SOFTWARE_ID PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC, SOFTWARE_LICENCE" +
            " FROM PRODUCTS, SOFTWARE" + " WHERE PRODUCTS.PRODUCT_ID = SOFTWARE.PRODUCT_ID AND PRODUCTS.PRODUCT_ID = " +
            softwareId;

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Software s = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Software(softwareId, rs.getString("PRODUCT_DESC"), rs.getString("PRODUCT_NAME"),
                                 rs.getDouble("PRODUCT_RETAIL_PRICE"), rs.getString("SOFTWARE_LICENCE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closeResultSet(rs);
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }

        return (s == null) ? null : s;
    }
}
