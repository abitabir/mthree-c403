/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calcTests;
import com.mthree.c403softwaredevelopmentusingjavaproject.exercises.junit.calculator.Calc;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author khali
 */
public class MultTest {
    
    @Test
    public void testMult() {
        Calc c1 = new Calc();
        int multOutput = c1.mult(50, 20);
        assertEquals(1000, multOutput);
    }
    
}
