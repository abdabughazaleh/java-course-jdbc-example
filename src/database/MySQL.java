package database;

import java.sql.*;

public class MySQL extends DBUtiles {

    public Statement connect() throws SQLException {
        System.out.println("MySQL Connected.");
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_4",
                    "root", "");
            stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            con.close();
            stmt.close();
        }

    }

}
