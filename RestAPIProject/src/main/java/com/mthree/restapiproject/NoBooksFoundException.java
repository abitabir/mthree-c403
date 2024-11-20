/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.restapiproject;

/**
 *
 * @author khali
 */

public class NoBooksFoundException extends Exception {
    public NoBooksFoundException(String message) {
        super(message);
    }
}
