/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcTests;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.junit.calculator.Calc;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author khali
 */
public class AddTest {
    
    @Test
    public void testAdd() {
        Calc c1 = new Calc();
        int addOutput = c1.add(50, 20);
        assertEquals(70, addOutput);
    }
}
