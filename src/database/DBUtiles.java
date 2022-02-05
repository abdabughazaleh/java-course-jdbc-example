package database;

import java.sql.*;

public abstract class DBUtiles {


    abstract Statement connect() ;
    abstract void disConnect() ;


    public void query(String query) {
        try {
            ResultSet rs = connect().executeQuery(query);
            disConnect();
            while (rs.next()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String table, String columns[], String values[]) {
        try {

            StringBuilder builder = new StringBuilder();
            builder.append("insert into ");
            builder.append(table);
            builder.append("(");
            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    builder.append(columns[i] + ",");
                } else {
                    builder.append(columns[i]);
                }
            }
            builder.append(")");
            builder.append(" values");
            builder.append("(");
            for (int i = 0; i < values.length; i++) {
                if (i != columns.length - 1) {
                    builder.append("'" + values[i] + "',");
                } else {
                    builder.append("'" + values[i] + "'");
                }
            }
            builder.append(")");
            System.out.println(builder.toString());
            connect().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

    public void delete(String query) {
        try {
            connect().execute(query);
            System.out.println("User has been deleted.");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

    public boolean checkUserIfExist(String username) {
        try {

            ResultSet rs = connect().executeQuery("select * from users where username='" + username + "'");

            if (rs.next()) {
                return true;
            }
            disConnect();
            return false;
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
            return false;
        }
    }

}
