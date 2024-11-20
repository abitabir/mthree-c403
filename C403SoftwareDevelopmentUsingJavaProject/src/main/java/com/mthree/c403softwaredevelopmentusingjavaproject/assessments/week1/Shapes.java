/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.assessments.week1;

/**
 * Question4 ->
 *
 * Create abstract class Shape. Declare "draw()" function as abstract. From this
 * class define "Triangle","Polygon" and "Circle" . Create an array of Shape
 * having 3 elements. Store child objects into this array  and call their draw
 * function.
 * 
 * @author abir
 */

abstract class Shape {
    abstract void draw();
}

class Triangle extends Shape {
    
    void draw() {
        System.out.println("Drawing Triangle...");
    }
    
}


class Polygon extends Shape {
    
    void draw() {
        System.out.println("Drawing Polygon...");
        
    }
    
}


class Circle extends Shape {
    
    void draw() {
        System.out.println("Drawing Circle...");
        
    }
    
}


public class Shapes {
    
    public static void main(String[] args) {
        
        Triangle triangle = new Triangle();
        Polygon polygon = new Polygon();
        Circle circle = new Circle();
        Shape[] drawing = new Shape[3];
        drawing[0] = triangle;
        drawing[1] = polygon;
        drawing[2] = circle;
        drawing[0].draw();
        drawing[1].draw();
        drawing[2].draw();
        
    }
    
}
