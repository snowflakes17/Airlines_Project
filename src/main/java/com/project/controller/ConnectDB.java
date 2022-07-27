package com.project.controller;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

    public Statement getConnection(){
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver loaded");

            // Try to connect
            connection =
                    DriverManager.getConnection("jdbc:mariadb://localhost/Airlines_project", "foo", "bar");
            System.out.println("It works!");
        }
        catch (Exception e){
            System.out.println("Error");
        }
//        finally {
//            try {
//                connection.close();
//            }catch (Exception e){}
//        }

        Statement l = null;
        try {
            l = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }
}
