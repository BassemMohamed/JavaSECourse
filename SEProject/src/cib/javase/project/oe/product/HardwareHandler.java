package cib.javase.project.oe.product;

import cib.javase.project.oe.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HardwareHandler {
    
    public static void insertHardware(Hardware h) {
        
        String sql = "INSERT INTO PRODUCTS"
            + "(PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)" 
            + " VALUES(?,?,?)";
        
        Connection conn = DBConnectionFactory.initConn(false);
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, h.getName());
            ps.setDouble(2, h.getPrice());
            ps.setString(3, h.getDescription());
            ps.executeUpdate();
            
            sql = "INSERT INTO HARDWARE"
                + "(HARDWARE_WARRANTY_PRD, PRODUCT_ID)" 
                + " VALUES(?,PRODUCTS_SEQ.CURRVAL)";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, h.getWarrantyPeriod());
            ps.executeUpdate();
            conn.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
    }
    
        
    public static Hardware getHardware(int hardwareId) {
        String sql = "SELECT PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC, HARDWARE_WARRANTY_PRD" 
            +" FROM PRODUCTS, HARDWARE"
            +" WHERE PRODUCTS.PRODUCT_ID = HARDWARE.PRODUCT_ID AND HARDWARE_ID = " 
            + hardwareId;
        
        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Hardware h = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                h = new Hardware(hardwareId, rs.getString("PRODUCT_DESC"), rs.getString("PRODUCT_NAME"),
                                 rs.getDouble("PRODUCT_RETAIL_PRICE"), rs.getInt("HARDWARE_WARRANTY_PRD"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closeResultSet(rs);
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }
        
        return (h == null)? null : h;
    }
    
}
