package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle extends DBUtiles {

    public Statement connect() {
        System.out.println("MySQL Connected.");
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
            stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
