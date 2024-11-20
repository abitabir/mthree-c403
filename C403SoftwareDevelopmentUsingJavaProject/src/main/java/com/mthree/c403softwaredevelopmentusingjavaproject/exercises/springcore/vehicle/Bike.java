/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.vehicle;
/**
 *
 * @author khali
 */

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
public class Bike implements Vehicle {
    
    @Getter @Setter private String bikeColour = "silver";
    @Getter final private int wheelsNumber = 2;
    
    /* 
    public Bike() {  // @NoArgsConstructor auto-generates this boiler plate code
    }

    public Bike(String bikeColour) {  // @AllArgsConstructor auto-generates this boiler plate code
            this.bikeColour = bikeColour;
    }

    public String getBikeColour() {  // @Getter auto-generates this boiler plate code
            return bikeColour;
    }

    public void setBikeColour(String bikeColor) {  // @Setter auto-generates this boiler plate code
            this.bikeColour = bikeColour;
    }

    public String getWheelsNumber() {  // @Getter auto-generates this boiler plate code
            return wheelsNumber;
    }

    @Override public String toString() {  // @toString auto-generates this boiler plate code
        return "Bike(bikeColour=" + this.bikeColour + ", wheelsNumber=" + this.wheelsNumber + ")";
    }
     */

    public void ride() {
        System.out.println("Riding a bike...");
    }
}
