package com.mthree.restapiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementSystemApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(BookManagementSystemApplication.class, args);
        System.out.println("Server is running...");
    }
}
