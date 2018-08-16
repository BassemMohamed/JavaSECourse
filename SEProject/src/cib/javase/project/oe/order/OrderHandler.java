package cib.javase.project.oe.order;

import cib.javase.project.oe.customer.Customer;
import cib.javase.project.oe.customer.CustomerHandler;
import cib.javase.project.oe.db.DBConnectionFactory;
import cib.javase.project.oe.product.Hardware;

import cib.javase.project.oe.product.HardwareHandler;
import cib.javase.project.oe.product.Product;

import cib.javase.project.oe.product.SoftwareHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class OrderHandler {
    
    public static void insertOrder( Order o ) {
        
        String sql = "INSERT INTO ORDERS" 
            + " (ORDER_DATE, ORDER_TOTAL, CUSTOMER_ID)"
            + " VALUES(?,?,?)";
        
        Connection conn = DBConnectionFactory.initConn(false);
        PreparedStatement ps = null;
        
        try {
           ps = conn.prepareStatement(sql);
           ps.setDate(1, new java.sql.Date(o.getOrderDate().getTime()) );
           ps.setDouble(2, o.getOrderTotal());
           ps.setInt(3, o.getCustomer().getId());
           ps.executeUpdate();
           
           for( OrderItem item : o.getItems() ) {
                sql = "INSERT INTO ORDER_ITEMS" 
                    + " (ORDER_ITEM_QTY, ORDER_ID, PRODUCT_ID)"
                    + " VALUES(?,ORDERS_SEQ.CURRVAL,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, item.getQuantity());
                ps.setDouble(2, item.getProduct().getId());
                ps.executeUpdate();
           }

           conn.commit();
           
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBConnectionFactory.closePreParedStatement(ps);
           DBConnectionFactory.closeConn();
       }

    }
    
    public static Order getOrder(int orderId) {
        String sql = "SELECT ORDER_DATE, ORDER_TOTAL, CUSTOMER_ID" 
            + " FROM ORDERS"
            + " WHERE ORDER_ID = ?";
        
        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order o = null;
        ArrayList<OrderItem> oiArry = new ArrayList<OrderItem>();
        
        try {
           ps = conn.prepareStatement(sql);
           ps.setInt(1, orderId);
           rs = ps.executeQuery();
           
            // Getting Fields of Order!
            while(rs.next()) {
                o = new Order(CustomerHandler.getCustomer(rs.getInt("CUSTOMER_ID")), orderId, rs.getDate("ORDER_DATE"));
            }
            
            // Getting Fields of Order Items!
            sql = "SELECT ORDER_ITEM_ID, ORDER_ITEM_QTY, PRODUCT_ID" 
                        + " FROM ORDER_ITEMS"
                        + " WHERE ORDER_ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            while(rs.next()) {
                Product h = HardwareHandler.getHardware(rs.getInt("PRODUCT_ID"));
                Product s = SoftwareHandler.getSoftware(rs.getInt("PRODUCT_ID"));
                Product p = (h == null) ? s : h;
                OrderItem oi = new OrderItem(rs.getInt("ORDER_ITEM_ID"), p, rs.getInt("ORDER_ITEM_QTY"));
                oiArry.add(oi);
            }
            o.setItems(oiArry);
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           DBConnectionFactory.closePreParedStatement(ps);
           DBConnectionFactory.closeConn();
        }
        
        return (o == null) ? null : o;
    }
    
}
