/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.mobile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author khali
 */
public class App {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("springCoreMobileConfig.xml");

        Apple d1 = (Apple) context.getBean("apple");
        System.out.println(d1.powerOn());
        System.out.println(d1.getManufacturedDate());
        System.out.println(d1);
        
        Samsung d2 = (Samsung) context.getBean("samsung");
        System.out.println(d2.powerOn());
        System.out.println(d2.getManufacturedDate());
        System.out.println(d2);
    }
    
}
