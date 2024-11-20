/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.dao;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.model.StudentModel;

/**
 *
 * @author khali
 */
public interface StudentDAOInterface {
    void addStudent(StudentModel student);

    StudentModel getStudent(String name);

    void updateStudent(StudentModel student);

    void deleteStudent(String name);
}
