/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.assessments.week1;

/**
 * Question3 ->
 *
 *
 * Create interface "Game" , have an abstract method "play()". From this
 * interface define "Cricket" , "FootBall" and "Tennis". Now Define one more
 * class public class Demo. In this class have a method "perform" which will take
 * interface reference as parameter. Inside "perform()" see to it that any child
 * object passed ,its "play()" method should be invoked.
 * 
 * @author abir
 */

interface Game {
    
    public void play();
}

class Cricket implements Game {
    
    public void play() {
        System.out.println("Playing Cricket...");
    }

}

class Football implements Game {
    
    public void play() {
        System.out.println("Playing Football...");

    }

}

class Tennis implements Game {
    
    public void play() {
        System.out.println("Playing Tennis...");

    }

}

public class Demo {
    
    public void perform(Game child){
        child.play();
    } 
    
    public static void main(String[] args) {
        Demo demo = new Demo();
        
        Game cricket = new Cricket();
        demo.perform(cricket);
        Game football = new Football();
        demo.perform(football);
        Game tennis = new Tennis();
        demo.perform(tennis);

    }
}
