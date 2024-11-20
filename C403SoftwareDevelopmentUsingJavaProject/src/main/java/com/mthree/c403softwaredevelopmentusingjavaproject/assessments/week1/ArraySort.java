/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.assessments.week1;
import java.util.Random;
// import java.util.Arrays;

/**
 * Question2 ->
 *
 * Initialize a single dimension array and sort it in ascending order.
 * 
 * @author abir
 */
public class ArraySort {
    
    int[] sortArray(int[] intArray) {

        int swapping;
        
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - 1 - i; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    swapping = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = swapping;
                }
            }
        }
        
        return intArray;
    }
    
    int[] createArray(int length) {
        
        Random rndm = new Random();
        int[] newArray;
        newArray = new int[length];
        
        for (int i = length - 1; i >= 0 ; i--) {
            newArray[i] = rndm.nextInt(10);
        }
        
        return newArray;
    }
    
    void printArray(int[] arrayToPrint) {
        String arrayToString = "";
        
        arrayToString += "[";
        for (int i = 0; i < arrayToPrint.length; i++) {
            arrayToString += arrayToPrint[i] + ",";
        }
        
        arrayToString = arrayToString.substring(0, arrayToString.length() - 1) + "]";
        
        System.out.println(arrayToString);
    }
    
    public static void main(String[] args) {
        ArraySort sortingArray = new ArraySort();
        
        int[] newArray = sortingArray.createArray(5);
        sortingArray.printArray(newArray);
        int[] sortedArray = sortingArray.sortArray(newArray);
        sortingArray.printArray(sortedArray);
    }
    
}
