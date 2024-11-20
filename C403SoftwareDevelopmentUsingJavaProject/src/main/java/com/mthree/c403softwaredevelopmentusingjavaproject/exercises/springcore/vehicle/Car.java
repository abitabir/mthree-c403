/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.exercises.springcore.vehicle;

/**
 *
 * @author khali
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;  // !!! not import lombok.Value;  // can't use @Getter and @Setter with THAT @Value
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car implements Vehicle {
    
    @Getter @Setter @Value("blue") private String carColour;  // @Value("blue") is string value injection  // not to be confused with @Value
    /* 
    public Car() {  // @NoArgsConstructor auto-generates this boiler plate code
    }

    public Car(String carColour) {  // @AllArgsConstructor auto-generates this boiler plate code
            this.carColour = carColour;
    }

    public String getCarColour() {  // @Getter auto-generates this boiler plate code
            return carColour;
    }

    public void setCarColour(String carColour) {  // @Setter auto-generates this boiler plate code
            this.carColour = carColour;
    }

    @Override public String toString() {  // @toString auto-generates this boiler plate code
        return "Car(carColour=" + this.carColour + ")";
    }
    */

    public void ride() {
        System.out.println("Riding a car...");
    }
}

