/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.assessments.week1;

/**
 * Question5 ->
 *
 * Explain the concept of composition in OOP. Create two classes, Author and
 * Book. The Book class should have a reference to the Author class
 * (composition). Write a program to create a book with its author and display
 * their details.
 * 
 * @author abir
 */

    
class Author {
    String aname;

    Author(String aname) {
        this.aname = aname;
    }
    
    public String getAname() {
        return this.aname;
    }
}

class Book  {
    Author authoredBy;
    String bname; 
    
    public String getBname() {
        return this.bname;
    }
    
    public String getBookInfo() {
        
        return this.getBname() + " is authored by " + this.authoredBy.getAname();
    }
    
    Book(String bookName, String authorName){
        this.bname = bookName;
        Author author = new Author(authorName);
        this.authoredBy = author;
    }
}

public class Authored {
    
    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1");
        System.out.println(book1.getBookInfo());
        
    }
}
