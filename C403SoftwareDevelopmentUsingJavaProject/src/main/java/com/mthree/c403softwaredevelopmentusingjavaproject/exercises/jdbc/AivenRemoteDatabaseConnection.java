/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.jdbc;

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

public class AivenRemoteDatabaseConnection {

    private final String host = "mysql-mthree-jdbc-abir-mthree-week-2.k.aivencloud.com";
    private final String port = "24863";
    private final String userName = "avnadmin";
    private final String password = "****";

    public String getHost() {
        return this.host;
    }

    public String getPort() {
        return this.port;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public static void main(String[] args) {
        
        AivenRemoteDatabaseConnection remoteDbCredentials = new AivenRemoteDatabaseConnection();
        JavaDatabaseConnection dbConnection = new JavaDatabaseConnection();
        dbConnection.setHost(remoteDbCredentials.getHost());
        dbConnection.setPort(remoteDbCredentials.getPort());
        dbConnection.setUserName(remoteDbCredentials.getUserName());
        dbConnection.setPassword(remoteDbCredentials.getPassword());
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
            System.out.println("Remote JDBC program ended.");
        }
    }

}


	 
