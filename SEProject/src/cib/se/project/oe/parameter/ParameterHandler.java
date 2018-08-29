package cib.se.project.oe.parameter;

import cib.se.project.oe.db.DBConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParameterHandler {

    public static double getParameter(String name) {

        String sql = "SELECT PARAM_VALUE" + " FROM PARAMETERS" + " WHERE PARAM_NAME = ?";

        Connection conn = DBConnectionFactory.initConn(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        double val = -1;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                val = rs.getDouble("PARAM_VALUE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.closeResultSet(rs);
            DBConnectionFactory.closePreParedStatement(ps);
            DBConnectionFactory.closeConn();
        }

        return (val == -1) ? null : val;
    }
}
