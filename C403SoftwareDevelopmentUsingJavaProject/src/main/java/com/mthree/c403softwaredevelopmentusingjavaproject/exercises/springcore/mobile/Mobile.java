/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.mobile;

/**
 *
 * @author khali
 */

public abstract class Mobile implements Device {
    
    String operatingSystem;
    String companyLogo;
    int manufacturedDate;
    
    public String powerOn() {
        return "mobile is powering on";
    }
    
}

