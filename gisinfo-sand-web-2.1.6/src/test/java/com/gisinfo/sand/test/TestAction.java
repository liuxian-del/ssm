package com.gisinfo.sand.test;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TestAction {

    private Connection conn;

    @Before
    public void init() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        conn = DriverManager.getConnection(url, "root", "123456");
        Statement stmt = conn.createStatement();


        //stmt.execute("CREATE TABLE geomtest(mycirc polygon)");
        //stmt.close();
    }

    @Test
    public void destroy() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @Test
    public void insertCircle() throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO geomtest(mycirc) VALUES (GeomFromText('POLYGON ((11))', 4326))")) {
            ps.executeUpdate();
            ps.close();
        }
    }
}
