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
public class DivTest {
    
    @Test
    public void testDiv() {
        Calc c1 = new Calc();
        float divOutput = c1.div(5, 20);
        float delta = 0.0f;  // where delta is the maximum difference (delta) between expected and actual for which both numbers are still considered equal
        assertEquals(0.25, divOutput, delta);
    }
    
}
