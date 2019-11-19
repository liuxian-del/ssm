package com.gisinfo.sand.test;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TestAction {

    private Connection conn;

    @Before
    public void init() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://192.168.0.133:5432/sde";
        conn = DriverManager.getConnection(url, "sdedata", "sdedata");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE geomtest(mycirc polygon)");
        stmt.close();
    }

    @Test
    public void destroy() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @Test
    public void insertCircle() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO geomtest(mycirc) VALUES (GeomFromText('POLYGON (( 52 28, 52 23, 58 23, 58 28, 52 28))', 4326))");
        ps.executeUpdate();
        ps.close();
    }
}
