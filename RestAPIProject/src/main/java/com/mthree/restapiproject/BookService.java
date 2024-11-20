/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.restapiproject;

/**
 *
 * @author khali
 */

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {  // Book Management System Service
    
//    @Autowired private BookDao bookDao;  // field injection  // but we can't use because we want to initialise the database
    private final BookDao bookDao;
    @Autowired public BookService(BookDao bookDao) {  // constructor injection
        this.bookDao = bookDao;
//        initialiseDatabase();  // don't need after initial execution
    }

    private void initialiseDatabase() {
        try {
            bookDao.createDatabase();
            bookDao.createTable();
        } catch (SQLException e) {
            throw new RuntimeException("Database initialisation error", e);
        }
    }

    public List<Book> getAllBooks() throws NoBooksFoundException {
        try {
            List<Book> books = bookDao.readAllFromDatabase();
            if (books.isEmpty()) {
                throw new NoBooksFoundException("No books found in the database.");
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while retrieving books", e);
        }
    }

    public Book getBookByID(int id) throws BookNotFoundException {
        try {
            Optional<Book> book = bookDao.readFromDatabase(id);
            return book.orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while retrieving the book", e);
        }
    }

    public void deleteBookByID(int id) throws BookNotFoundException {
        try {
            // Check if the book exists before trying to delete
            Optional<Book> book = bookDao.readFromDatabase(id);
            if (book.isEmpty()) {
                throw new BookNotFoundException("Book not found with ID: " + id);
            }
            bookDao.deleteFromDatabase(id);
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while deleting the book", e);
        }
    }

    public void updateBookByID(Book updatedBookObject) throws BookNotFoundException {
        try {
            Optional<Book> book = bookDao.readFromDatabase(updatedBookObject.getId());
            if (book.isEmpty()) {
                throw new BookNotFoundException("Book not found with ID: " + updatedBookObject.getId());
            }
            bookDao.updateToDatabase(updatedBookObject);
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while updating the book", e);
        }
    }
    
    public Book addBook(Book bookObject) throws BookCreationException {
        try {
            Book book = bookDao.createInDatabase(bookObject);
            if (book.getId() == 0) {  // GENERATED_KEYS should always return greater than 0 as default AUTO_INCREMENT value is 1
                throw new BookCreationException("Book creation failed; no ID was generated.");
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException("Database error occurred while adding the book", e);
        }
    }
}