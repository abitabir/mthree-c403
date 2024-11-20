/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.restapiproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author khali
 */

@RestController
@RequestMapping("/books")
public class BookController {  // Book Management System Controller
    
//    @Autowired private BookService bookService;  // field injection
    private final BookService bookService;
    @Autowired public BookController(BookService bookService) {  // constructor injection
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.ok(books);  // 200
        } catch (NoBooksFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookBasedOnId(@PathVariable("id") int id) {
        try {
            Book book = bookService.getBookByID(id);
            return ResponseEntity.ok(book);  // 200
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500
        }
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book bookObject) {
        if (bookObject.getTitle() == null || bookObject.getAuthor() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // 400
        }
        try {
            Book createdBook = bookService.addBook(bookObject);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);  // 201
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Book updatedBookObject, @PathVariable("id") int id) {
        if (updatedBookObject.getTitle() == null || updatedBookObject.getAuthor() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // 400
        }
        try {
            updatedBookObject.setId(id);
            bookService.updateBookByID(updatedBookObject);
            return ResponseEntity.noContent().build();  // 204
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            bookService.deleteBookByID(id);
            return ResponseEntity.noContent().build();  // 204
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  // 500
        }
    }
}