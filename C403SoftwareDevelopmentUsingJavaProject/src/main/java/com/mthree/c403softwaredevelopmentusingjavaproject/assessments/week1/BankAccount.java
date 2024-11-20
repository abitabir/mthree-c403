/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.c403softwaredevelopmentusingjavaproject.assessments.week1;

/**
 * Question1 ->
 * Define encapsulation and demonstrate it by creating a BankAccount class.
 * Ensure that the balance cannot be set directly from outside the class but can
 * be modified only using methods like deposit() and withdraw().
 * 
 * @author abir
 */
public class BankAccount {
    
    private float balance;
    
    public void deposit(float depositAmount) {

        balance = balance + depositAmount;
    }
    
    public void withdraw(float withdrawalAmount) {
        balance = balance - withdrawalAmount; 
    }
    
    public float checkBalance() {
        return balance;
    }
    
    BankAccount() {
    
        balance = 0;
    }
    
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.deposit(10.5f);
        ba.withdraw(5.6f);
        System.out.println(ba.checkBalance());
 
    }
    
}
