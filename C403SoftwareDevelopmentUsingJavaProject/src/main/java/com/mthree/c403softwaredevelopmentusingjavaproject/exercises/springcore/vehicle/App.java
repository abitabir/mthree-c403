/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.vehicle;

/**
 *
 * @author khali
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args )
    {
        
        Bike b0 = new Bike();  // tightly coupled object creation
        b0.ride();
        System.out.println(b0);
        
        Vehicle c0 = new Car();  // less tightly coupled object creation due to upcasting
        c0.ride();
        System.out.println(c0);
        
        // object creation within code is a hassle because you have to create and maintain object and rebuild after every change yourself
        // instead we can provide objects from outside the code via a dependency injection
        // objects can be provided by beans in spring configuration xml files

        ApplicationContext context = new ClassPathXmlApplicationContext("springCoreVehicleConfig.xml");  // variable name can also be factory
        // ApplicationContext is where Spring holds beans: instances of objects to be managed and distributed automatically

        // xml configuration injections

        Bike b1 = (Bike) context.getBean("vehicle0");
        b1.ride();
        System.out.println(b1);
        
        Vehicle c1 = (Vehicle) context.getBean("vehicle1");
        c1.ride();
        System.out.println(c1);
       
        Bike b2 = (Bike) context.getBean("vehicle2");
        b2.ride();
        b2.setBikeColour("black");
        System.out.println(b2);
       
        Car c2 = (Car) context.getBean("vehicle3");
        c2.ride();
        System.out.println(c2);
       
        Bike b3 = (Bike) context.getBean("vehicle4");
        b3.ride();
        System.out.println(b3);
        
        // annotation configuration injections
        
        Car c3 = (Car) context.getBean("car");  // @Component above Car class definition creates a bean of that class whose id is the class name lowercased
        c3.ride();
        System.out.println(c3.getCarColour());
        System.out.println(c3);
       
        Bike b4 = (Bike) context.getBean("bike");  // @Component above Bike class definition creates a bean of that class whose id is the class name lowercased
        b4.ride();
        System.out.println(b4.getBikeColour());
        System.out.println(b4);
    }
}