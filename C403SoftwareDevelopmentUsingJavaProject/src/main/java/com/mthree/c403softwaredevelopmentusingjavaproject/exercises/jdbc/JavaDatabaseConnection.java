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
 * Task brief:
 * MAVEN ---> connection --> setCon()
 * update -> void updateMethod() --> update
 * delete -> void deleteMethod() --> delete app.java or main.java -->
 * setCon()--> update or delete
 * 
 * Database -> Table -> Emp: id, name, job, salary, department
 * 
 * @author khali
 */

public class JavaDatabaseConnection {

//    prestep -> add to pom.xml:
//    <dependencies>
//        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
//        <dependency>
//            <groupId>mysql</groupId>
//            <artifactId>mysql-connector-java</artifactId>
//            <version>8.0.28</version>
//        </dependency>
//    </dependencies>

    private String host;
    private String port;
    private String userName;
    private String password;
//    //    private final String databaseName;
    private Connection connection;
    private Statement statement;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    //    public String setDatabaseName(String databaseName) {
//    //        this.databaseName = databaseName;
//    //    }

    public void setCon(Connection connection) {
        this.connection = connection;
    }

    public void setStat(Statement statement) {
        this.statement = statement;
    }

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

//    //    public String getDatabaseName() {
//    //        return databaseName;
//    //    }

    public Connection getCon() {
        return this.connection;
    }

    public Statement getStat() {
        return this.statement;
    }

    public PreparedStatement makePStat(String sql) throws SQLException {
        return this.getCon().prepareStatement(sql);
    }
    
//    //    public void setConWithDatabaseName(String host, String port, String databaseName, String userName, String password) throws SQLException, ClassNotFoundException {
//    ////      step1 -> driver download  // searching for class via reflection API
//    //        Class.forName("com.mysql.cj.jdbc.Driver");
//    ////      step2 -> connection road
//    //        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" 
//    //                + databaseName, userName, password);
//    //        this.connection = connection;
//    //        Statement statement = this.connection.createStatement();
//    //        this.statement = statement;
//    //        System.out.println("Connection established.");
//    //    }
    
    public void setCon(String host, String port, String userName, String password) throws SQLException, ClassNotFoundException {
//      step1 -> search for driver class (via reflection API)
        Class.forName("com.mysql.cj.jdbc.Driver");
//      step2 -> create connection between java code and mysql database (like a road)
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, userName, password);
        this.connection = connection;
//      step3 -> create connection object to send sql query or retrieve data via connection (like a car to travel on road)
        Statement dbstatement = this.connection.createStatement();
        this.statement = dbstatement;
        System.out.println("Connection established.");
    }
    
    public void createDatabase(String databaseName) throws SQLException {
        
        String dropDatabase = "DROP DATABASE IF EXISTS " + databaseName + ";";
        String createDatabase = "CREATE DATABASE " + databaseName + ";";
        String useDatabase = "USE " + databaseName + ";";
    
        this.getStat().execute(dropDatabase);
        this.getStat().execute(createDatabase);
        this.getStat().execute(useDatabase);
        System.out.println("Database created.");
    }
        
    public void createTable(String tableName) throws SQLException {

        String dropTable = "DROP TABLE IF EXISTS " + tableName + ";";
        String createTable = "CREATE TABLE " + tableName + " ("
                + "id INT NOT NULL AUTO_INCREMENT, "  // default AUTO_INCREMENT starting value is 1
                + "name VARCHAR(100), "
                + "age INT, "
                + "PRIMARY KEY (id)" + ")" + ";";

        Statement tbstatement = this.getCon().createStatement();

        tbstatement.execute(dropTable);
        tbstatement.execute(createTable);
        
        tbstatement.close();
        
        System.out.println("Table created.");
    }
    
// PreparedStatement helps prevent SQL injection attacks via CRUD operations and improves performance for repeated SQL statement executions
// Cannot use PreparedStatement to set anything part of the actual SQL query keywords (e.g. database name, table names) (using PreparedStatement.setString() will not work)
// Can convert statement execution and closing to try with resources
        
    public void createInDatabase(String table, String name, int age) throws SQLException {
//        String sql = "INSERT INTO " + table + " (name, age) VALUES ('" + name + "', " + age + ")" + ";";
//        PreparedStatement pstatement = this.makePStat(sql);

        String sql = String.format("INSERT INTO %s (name, age) VALUES (?, ?);", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        // set parameters
        pstatement.setString(1, name);
        pstatement.setInt(2, age);
        
        pstatement.executeUpdate();
        pstatement.close();
        System.out.println("Update successful.");
    }
    
    public void updateToDatabase(String table, int id, int age) throws SQLException {
//        String sql = "UPDATE " + table + " SET age = " + age + " WHERE id = " + id + ";";
//        PreparedStatement pstatement = this.makePStat(sql);
        
        String sql = String.format("UPDATE %s SET age = ? WHERE id = ?;", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        // set parameters
        pstatement.setInt(1, age);
        pstatement.setInt(2, id);
        
        pstatement.executeUpdate();
        pstatement.close();
        System.out.println("Update successful.");
    }
    
    public void updateToDatabase(String table, int id, String name) throws SQLException {
//        String sql = "UPDATE " + table + " SET name = '" + name + "' WHERE id = " + id + ";";
//        PreparedStatement pstatement = this.makePStat(sql);

        String sql = String.format("UPDATE %s SET name = ? WHERE id = ?;", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        // set parameters
        pstatement.setString(1, name);
        pstatement.setInt(2, id);

        pstatement.executeUpdate();
        pstatement.close();
        System.out.println("Update successful.");
    }

    public void readFromDatabase(String table, int id) throws SQLException {
//        String sql = "SELECT name, age FROM " + table + " WHERE id = " + id + ";";
//        PreparedStatement pstatement = this.makePStat(sql);
        
        String sql = String.format("SELECT name, age FROM %s WHERE id = ?;", table);  // or String sql = String.format("SELECT * FROM %s WHERE id = ?;", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        // set parameters
        pstatement.setInt(1, id);
        
        ResultSet rs = pstatement.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(1) + "  " + rs.getInt(2)); // or System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getInt(3));
        }
        pstatement.close();
        System.out.println("Read successful.");
    }

    public void readAllFromDatabase(String table) throws SQLException {
//        String sql = "SELECT * FROM " + table + ";";
//        PreparedStatement pstatement = this.makePStat(sql);

        String sql = String.format("SELECT * FROM %s;", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        
        ResultSet rs = pstatement.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getInt(3));
        }
        pstatement.close();
        System.out.println("Read successful.");
    }

    public void deleteFromDatabase(String table, int id) throws SQLException {
//        String sql = "DELETE FROM " + table + " WHERE id = " + id + ";";
//        PreparedStatement pstatement = this.makePStat(sql);

        String sql = String.format("DELETE FROM %s WHERE id = ?;", table);
        PreparedStatement pstatement = this.makePStat(sql);  // prepare statement
        // set parameters
        pstatement.setInt(1, id);

        pstatement.executeUpdate();
        pstatement.close();
        System.out.println("Delete successful.");
    }

}
	 
