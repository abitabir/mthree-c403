/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.multithreading;

/**
 * Camera --> Click()
 * 
 * Andre --> Knight Family
 * 
 * Aysu --> Korkmaz Family
 * 
 * @author khali
 */


class Camera {
    
    public void ClickAsync() {  // asynchronous method
        System.out.println("entered by " + Thread.currentThread().getName());
        for (int shutter = 0; shutter < 10; shutter++) {
            System.out.println("click " + shutter + " by " + Thread.currentThread().getName());
        }
        System.out.println("exit by " + Thread.currentThread().getName());
    }
    
    public synchronized void ClickSync() {  // synchronous method
        System.out.println("entered by " + Thread.currentThread().getName());
        for (int shutter = 0; shutter < 10; shutter++) {
            System.out.println("click " + shutter + " by " + Thread.currentThread().getName());
        }
        System.out.println("exit by " + Thread.currentThread().getName());
    }
    
    public void ClickAsyncAsync() {  // asynchronous method
        System.out.println("entered by " + Thread.currentThread().getName());
        {  // asynchronous block
            for (int shutter = 0; shutter < 10; shutter++) {
                System.out.println("click " + shutter + " by " + Thread.currentThread().getName());
            }
        }
        System.out.println("exit by " + Thread.currentThread().getName());
    }
    
    public void ClickAsyncSync() {  // asynchronous method
        System.out.println("entered by " + Thread.currentThread().getName());
        synchronized(this) {  // synchronous block
            for (int shutter = 0; shutter < 10; shutter++) {
                System.out.println("click " + shutter + " by " + Thread.currentThread().getName());
            }
        }
        System.out.println("exit by " + Thread.currentThread().getName());
    }
}

abstract class Family implements Runnable {
    
    String surname;
    String forename;
    Camera camera;

}

class KnightFamily extends Family {
    
    KnightFamily(String forename, Camera camera) {
    
        this.surname = "Knight";
        this.forename = forename;
        this.camera = camera;
    }
    
    @Override
    public void run() {
        this.camera.ClickAsyncSync();
    }
}

class KorkmazFamily extends Family {
    
    KorkmazFamily(String forename, Camera camera) {
    
        this.surname = "Korkmaz";
        this.forename = forename;
        this.camera = camera;
    }
    
    @Override
    public void run() {
        this.camera.ClickAsyncSync();
    }
}

public class MultiThreading {
    
    public static void main(String[] args) {
        Camera c = new Camera();
        KnightFamily andre = new KnightFamily("Andre", c);
        Thread tAndre = new Thread(andre);
        KorkmazFamily aysu = new KorkmazFamily("Aysu", c);
        Thread tAysu = new Thread(aysu);
        
        tAndre.start();
        tAndre.setName("AndreThread");
        
        tAysu.start();
        tAysu.setName("AysuThread");
    }
    
}
