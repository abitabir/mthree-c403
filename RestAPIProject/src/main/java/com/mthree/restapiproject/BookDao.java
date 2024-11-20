/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.restapiproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Setter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author khali
 */

@Component
public class BookDao {  // Book Management System DAO
    
//    @Autowired private BookDaoConfig credentials;  // field injection
    private final BookDaoConfig config;
    @Autowired public BookDao(BookDaoConfig credentials) {  // constructor injection
        this.config = credentials;
        setCon();
    }

    @Setter @Getter private Connection connection;
    
    public PreparedStatement makePStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public PreparedStatement makePStatementWithKeys(String sql, int autoGenKeys) throws SQLException {
        return connection.prepareStatement(sql, autoGenKeys);
    }

    public void setCon() {
        try {
            Class.forName(config.getDriver());
            this.connection = DriverManager.getConnection(config.getUrl() + config.getDatabaseName(), config.getUsername(), config.getPassword());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error establishing database connection", e);
        }
    }
    
    public void createDatabase() throws SQLException {
        String dropDatabase = "DROP DATABASE IF EXISTS " + config.getDatabaseName() + ";";
        String createDatabase = "CREATE DATABASE " + config.getDatabaseName() + ";";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropDatabase);
            stmt.execute(createDatabase);
        }
    }

    public void createTable() throws SQLException {
        String dropTable = "DROP TABLE IF EXISTS " + config.getTableName() + ";";
        String createTable = "CREATE TABLE " + config.getTableName() + " ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "title VARCHAR(255), "
                + "author VARCHAR(100), "
                + "PRIMARY KEY (id));";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTable);
            stmt.execute(createTable);
        }
    }

    public Book createInDatabase(Book book) throws SQLException, BookCreationException {
        String sql = String.format("INSERT INTO %s (title, author) VALUES (?, ?);", config.getTableName());
        try (PreparedStatement pstatement = this.makePStatementWithKeys(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstatement.setString(1, book.getTitle());
            pstatement.setString(2, book.getAuthor());
            int affectedRows = pstatement.executeUpdate();

            if (affectedRows == 0) {
                throw new BookCreationException("Book creation failed; no rows affected.");
            }

            try (ResultSet generatedKeys = pstatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                } else {
                    throw new BookCreationException("Book creation failed; no ID obtained.");
                }
            }
        }
        return book;
        // expected behavior of create is to return something (even Book without ID on failure)
    }


    public void updateToDatabase(Book book) throws SQLException {
        String sql = String.format("UPDATE %s SET title = ?, author = ? WHERE id = ?;", config.getTableName());
        try (PreparedStatement pstatement = this.makePStatement(sql)) {
            pstatement.setString(1, book.getTitle());
            pstatement.setString(2, book.getAuthor());
            pstatement.setInt(3, book.getId());
            pstatement.executeUpdate();
        }
        // expected behavior of update is to return nothing even on failure
    }

    public Optional<Book> readFromDatabase(int id) throws SQLException {
        String sql = String.format("SELECT title, author FROM %s WHERE id = ?;", config.getTableName());
        try (PreparedStatement pstatement = this.makePStatement(sql)) {
            pstatement.setInt(1, id);
            try (ResultSet rs = pstatement.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book(id, rs.getString("title"), rs.getString("author"));
                    return Optional.of(book);  // returns created book object with ID generated
                }
            }
        }
        return Optional.empty();  // returns empty Optional if no book with ID exists
        // expected behavior of read is to return something (even empty Optional on failure)
    }

    public List<Book> readAllFromDatabase() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = String.format("SELECT id, title, author FROM %s;", config.getTableName());
        try (PreparedStatement pstatement = this.makePStatement(sql);
             ResultSet rs = pstatement.executeQuery()) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
            }
        }
        return books;  // returns List with books if books exist or empty List if no books exist
        // expected behavior of read all is to return something (even empty List on failure)
    }

    public void deleteFromDatabase(int id) throws SQLException {
        String sql = String.format("DELETE FROM %s WHERE id = ?;", config.getTableName());
        try (PreparedStatement pstatement = this.makePStatement(sql)) {
            pstatement.setInt(1, id);
            pstatement.executeUpdate();
        }
        // expected behavior of delete is to return nothing even on failure
    }
}