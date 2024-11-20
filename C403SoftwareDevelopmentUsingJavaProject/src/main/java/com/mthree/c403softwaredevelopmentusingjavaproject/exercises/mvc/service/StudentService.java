/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.service;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.dao.StudentDAOInterface;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.model.StudentModel;

/**
 *
 * @author khali
 */
public class StudentService {
    private StudentDAOInterface studentDAO;

    public StudentService(StudentDAOInterface studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(String name, int age) {
        StudentModel student = new StudentModel(name, age);
        studentDAO.addStudent(student);
    }

    public StudentModel getStudent(String name) {
        return studentDAO.getStudent(name);
    }

    public void updateStudent(String name, int age) {
        StudentModel student = studentDAO.getStudent(name);
        if (student != null) {
            student.setAge(age);
            studentDAO.updateStudent(student);
        }
    }

    public void deleteStudent(String name) {
        studentDAO.deleteStudent(name);
    }

    public String getStudentDetails(String name) {
        StudentModel student = studentDAO.getStudent(name);
        if (student != null) {
            return String.format("Student Name: %s, Student Age: %d", student.getName(), student.getAge());
        } else {
            return "Student not found.";
        }

    }
}
