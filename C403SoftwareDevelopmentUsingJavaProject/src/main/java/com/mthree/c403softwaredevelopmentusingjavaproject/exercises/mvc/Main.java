/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.dao.StudentDAOImplementation;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.dao.StudentDAOInterface;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.service.StudentService;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.view.StudentView;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.controller.StudentController;

/**
 *
 * @author khali
 */
public class Main {

    public static void main(String[] args) {
        // Create DAO, Service and view
        StudentDAOInterface studentDAO = new StudentDAOImplementation();
        StudentService studentService = new StudentService(studentDAO);
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(studentService, view);

        // Add a student
        controller.addStudent("And", 22);
        controller.displayStudentDetails("And");

        // Update student
        controller.updateStudent("And", 20);
        controller.displayStudentDetails("And");

        // Delete student
        controller.deleteStudent("And");
        controller.displayStudentDetails("And"); // Should say "Student not found."
    }
    
}
