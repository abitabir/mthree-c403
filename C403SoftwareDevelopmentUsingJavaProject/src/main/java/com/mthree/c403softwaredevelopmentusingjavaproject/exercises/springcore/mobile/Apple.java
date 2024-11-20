/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.mobile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author khali
 */

@Component
@Getter
@Setter
@ToString
public class Apple extends Mobile {
    
    @Value("iOS") private String operatingSystem;
    @Value("Apple") private String companyLogo;
    @Value("2001") private int manufacturedDate;
    
    public String powerOn() {
        return this.companyLogo + " " + this.operatingSystem + " is powering on";
    }

}