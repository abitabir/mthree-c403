/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.jdbc;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.jdbc.JavaDatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author khali
 */

public class MySQLLocalDatabaseConnection {
    
//    prestep 1 -> start MySQL server in an administrator command prompt via the command:
//    mysqld --console // or net start MySQL80 if configured as a Windows Service
    
//    prestep 2 -> leave the command prompt running the MySQL server untouched to continue letting the server run
    
//    //    prestep 3 -> open MySQL command line client in another command prompt tab/window via the command:
//    //    mysql -u root -p
//    //      
//    //    prestep 4 -> in MySQL command line client, remove defaultdb database if it already exists via the command:
//    //    DROP DATABASE IF EXISTS defaultdb;
//    //    
//    //    prestep 5 -> in MySQL command line client, create defaultdb database:
//    //    CREATE DATABASE defaultdb;

    private final String host = "localhost";
    private final String port = "3306";
    private final String userName = "root";
    private final String password = "****";

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public static void main(String[] args) {
        
        MySQLLocalDatabaseConnection localDbCredentials = new MySQLLocalDatabaseConnection();
        JavaDatabaseConnection dbConnection = new JavaDatabaseConnection();
        dbConnection.setHost(localDbCredentials.getHost());
        dbConnection.setPort(localDbCredentials.getPort());
        dbConnection.setUserName(localDbCredentials.getUserName());
        dbConnection.setPassword(localDbCredentials.getPassword());
        String databaseName = "school";
        String tableName = "students";
        try {
//    //            dbConnection.setCon(dbConnection.getHost(), dbConnection.getPort(), dbConnection.getDatabaseName(), dbConnection.getUserName(), dbConnection.getPassword());
            dbConnection.setCon(dbConnection.getHost(), dbConnection.getPort(), dbConnection.getUserName(), dbConnection.getPassword());
            try {
                dbConnection.createDatabase(databaseName);
                dbConnection.createTable(tableName);
                for (int i = 1; i <= 10; i++) {
                    dbConnection.createInDatabase(tableName, "Aname" + i, i + 4);
                }
                dbConnection.readAllFromDatabase(tableName);
                dbConnection.readFromDatabase(tableName, 10);
                dbConnection.updateToDatabase(tableName, 10, 15);
                dbConnection.readFromDatabase(tableName, 10);
                dbConnection.updateToDatabase(tableName, 10, "Aname Asurname");
                dbConnection.readFromDatabase(tableName, 10);
                dbConnection.deleteFromDatabase(tableName, 10);
                dbConnection.readFromDatabase(tableName, 10);
                dbConnection.readAllFromDatabase(tableName);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.getStat().close();
                dbConnection.getCon().close();
                System.out.println("Connection closed.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection not closed.");
            e.printStackTrace();
        } finally {
            System.out.println("Local JDBC program ended.");
        }
    }
}

//    poststep 1 -> stop the MySQL server, in an adminstrator command prompt tab/window separate to the one running the MySQL server, via the command:
//    mysqladmin -u root shutdown -p // or net stop MySQL80 if configured as a Windows Service

	 
