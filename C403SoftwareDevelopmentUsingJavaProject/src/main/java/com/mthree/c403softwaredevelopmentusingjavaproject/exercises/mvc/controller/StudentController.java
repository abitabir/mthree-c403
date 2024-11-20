/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.controller;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.service.StudentService;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.view.StudentView;

/**
 *
 * @author khali
 */
public class StudentController {

    private StudentService studentService;
    private StudentView studentView;

    public StudentController(StudentService service, StudentView view) {
        this.studentService = service;
        this.studentView = view;
    }

    public void addStudent(String name, int age) {
        studentService.addStudent(name, age);
    }

    public void updateStudent(String name, int age) {
        studentService.updateStudent(name, age);
    }

    public void deleteStudent(String name) {
        studentService.deleteStudent(name);
    }

    public void displayStudentDetails(String name) {
        String studentInfo = studentService.getStudentDetails(name);
        studentView.displayStudentDetails(studentInfo);
    }
    
}