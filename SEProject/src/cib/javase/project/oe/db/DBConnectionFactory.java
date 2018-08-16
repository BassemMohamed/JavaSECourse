package cib.javase.project.oe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.Result;

public class DBConnectionFactory {
   
    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static final String USER = "oe";
    private static final String PASS = "oe";
    private static Connection conn = null;
    
    public static Connection initConn(boolean AutoCommit) {

        try {
            System.out.println("Opening DB Connection");
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(AutoCommit);
            System.out.println("Connection Successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public static void closePreParedStatement(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeConn() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     
}
