/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.dao;

import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.mvc.model.StudentModel;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author khali
 */
public class StudentDAOImplementation implements StudentDAOInterface {
    private Map<String, StudentModel> studentDatabase = new HashMap<>();

    @Override
    public void addStudent(StudentModel student) {
        studentDatabase.put(student.getName(), student);
    }

    @Override
    public StudentModel getStudent(String name) {
        return studentDatabase.get(name);
    }

    @Override
    public void updateStudent(StudentModel student) {
        studentDatabase.put(student.getName(), student);
    }

    @Override
    public void deleteStudent(String name) {
        studentDatabase.remove(name);
    }
}