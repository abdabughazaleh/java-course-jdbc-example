import database.DBUtiles;
import database.MySQL;
import database.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBUtiles db = new MySQL();
/*
        db.insert("insert into users(username,password,first_name,last_name) " +
                " values('Mohm' , '123123' , 'Mohmmad' , 'JLKANSF') ");*/
       /* db.insert("users",
                new String[]{"username", "password", "first_name", "last_name"},
                new String[]{"Khaleel", "111", "Khhhhhh", "AbuGhazaleh"});
*/


        Scanner i = new Scanner(System.in);
        System.out.print("Please Enter Username : ");
        String username = i.next();

        if (db.checkUserIfExist(username)) {
            String query = String.format("delete from users where username = '%s'", username);
            db.delete(query);
            db.query("select * from users");

        } else {
            System.out.println("User dosn't  exist.");
        }



    }
}
